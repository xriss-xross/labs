	import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class IOLabPartTwo {

	public IOLabPartTwo() {
		//Don't touch
	}
	
	public IOLabPartTwo(String[] args) throws IOException {
		File file = new File("programs.csv");
		ArrayList<OurData> data = parseCSVFile(file.toPath());
		for (int i = 0; i < data.size(); i++) {
			System.out.println("Program Description " + (i+1));
			data.get(i).printData();
			System.out.println();
		}

		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(file.toPath());
		File newFile = new File("newprograms.csv");
		String[] headers = lines.get(0).split(",");
		printCSVFile(headers, data, newFile.toPath());
	}
	
	public static void main(String[] args) throws IOException {
		new IOLabPartTwo(args);
	}
	
	public OurData parseCSVLine(Scanner scan, String[] headers) {
		
		OurData od = new OurData(headers);
		int index = 0;

		while (scan.hasNext()) {

			if (scan.hasNextBoolean()) {
				od.setField(headers[index], Boolean.parseBoolean(scan.next()));
			} else if (scan.hasNextInt()) {
				od.setField(headers[index], Integer.parseInt(scan.next()));
			} else {
				od.setField(headers[index], scan.next());
			}
			index++;
			if (index == headers.length) {
				index = 0;
			}

		}

		return od;
	}
	
	public ArrayList<OurData> parseCSVFile(Path path) throws IOException {
		//Don't Touch
		ArrayList<OurData> ourDataObjects = new ArrayList<>();
		//Every line of the file is read in for you into lines
		ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(path);
		
		/*Populate ourDataObjects from any given csv file using Scanner scan to assist.
		Remember, the first line contains the headers, so we grab
		this and transform it into an array of Strings.
		 */
		
		String[] headers = lines.get(0).split(",");
		
		for (int i = 1; i < lines.size(); i++) {
			try (Scanner scan = new Scanner(lines.get(i))) {
				scan.useDelimiter(",");
				ourDataObjects.add(parseCSVLine(scan, headers));
			}
		}
		
		return ourDataObjects;
	}
	
	public void printCSVFile(String[] headers, ArrayList<OurData> ourDataObjects, Path outPath) throws IOException {
		try (BufferedWriter bw = Files.newBufferedWriter(outPath)) {
			StringBuilder csvData = new StringBuilder();

			csvData.append(String.join(",", headers)).append("\n");

			for (int i = 0; i < ourDataObjects.size(); i++) {
				OurData data = ourDataObjects.get(i);
				String[] values = new String[headers.length];
				for (int j = 0; j < headers.length; j++) {
					values[i] = data.getFieldAsString(headers[i]);
				}
				csvData.append(String.join(",", values)).append("\n");
			}
			bw.write(csvData.toString());
		}

	}
	
}