/*************************************
 *  Filename:  SMTPInteraction.java
 *************************************/
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Open an SMTP connection to mailserver and send one mail.
 *
 */
public class SMTPInteraction {
    /** Socket to the SMTP server ***/
    private Socket connection;

    /* Streams for reading from and writing to socket */
    private InputStream is;
    private OutputStream os;

    private InputStreamReader isr;

    private BufferedReader fromServer;
    private DataOutputStream toServer;

    private static final String CRLF = "\r\n";

    /* Are we connected? Used in close() to determine what to do. */
    private boolean isConnected = false;

    /* Create an SMTPInteraction object. Create the socket and the 
       associated streams. Initialise SMTP connection. */
    public SMTPInteraction(EmailMessage mailmessage) throws IOException {

        // Open a TCP client socket with hostname and portnumber specified in
        // mailmessage.DestHost and  mailmessage.DestHostPort, respectively.
	    connection = new Socket(
            mailmessage.DestHost,
            mailmessage.DestHostPort
        );
	
        // attach the BufferedReader fromServer to read from the socket and
        // the DataOutputStream toServer to write to the socket
        is  = connection.getInputStream();
        os  = connection.getOutputStream();
        isr = new InputStreamReader(is);

        fromServer = new BufferedReader(isr);
	    toServer   = new DataOutputStream(os); 
        
        String response = fromServer.readLine();
        String code = response.substring(0, 3);

	    /* Read one line from server and check that the reply code is 220.
	    If not, throw an IOException. */
        if (!code.equals("220")) {
            throw new IOException(String.format("220 reply not received from server.\nGot: %s",
                code
            ));
        }

        /* SMTP handshake. We need the name of the local machine.
        Send the appropriate SMTP handshake command. */
        String localhost = InetAddress.getLocalHost().getHostName();
        sendCommand(String.format("HELO %s%s", localhost, CRLF), 250);

        isConnected = true;
    }


    /* Send message. Write the correct SMTP-commands in the
    correct order. No checking for errors, just throw them to the
    caller. */
    public void send(EmailMessage mailmessage) throws IOException {

        sendCommand(String.format("MAIL FROM: <%s>%s",
            mailmessage.Sender,
            CRLF
            ), 250);
        
        sendCommand(String.format("RCPT TO: <%s>%s",
            mailmessage.Recipient,
            CRLF
            ), 250);
        
        sendCommand(String.format("DATA%s",
            CRLF
            ), 354);
        
        toServer.writeBytes(mailmessage.Headers + CRLF);
        toServer.writeBytes(mailmessage.Body + CRLF);
        toServer.writeBytes("." + CRLF);
    }

    /* Close SMTP connection. First, terminate on SMTP level, then
       close the socket. */
    public void close() {
        isConnected = false;
        try {
            sendCommand(String.format("QUIT%s",
                CRLF
                ), 221);
            connection.close();
        } catch (IOException e) {
            System.out.println("Unable to close connection: " + e);
            isConnected = true;
        }
    }

    /* Send the SMTP command to the server. Check that the reply code is
       what is is supposed to be according to RFC 821. */
    private void sendCommand(String command, int rc) throws IOException {
        toServer.writeBytes(command);
        String response = fromServer.readLine();
        /* Write command to server and read reply from server. */

        /* Check that the server's reply code is the same as the parameter
        rc. If not, throw an IOException. */
        int ac = Integer.parseInt(response.substring(0, 3));
        if (ac != rc) {
            throw new IOException(
                String.format("Expected reply code %d but got %d: %s",
                    rc,
                    ac,
                    response
            ));
        }
    }
} 