//
// Coded by Prudence Wong 2021-03-06
// Updated 2023-02-25
//
// Note: You are allowed to add additional methods if you need.
// Name: Killian Carolan
// Student ID: 201823073 
//
// Time Complexity and explanation: 
// f denotes initial cabinet size
// n denotes the total number of requests 
// d denotes number of distinct requests
// You can use any of the above notations or define additional notation as you wish.
// 
// Each of the methods the functions use are analysed throughout the file but to summise:

// appendIfMiss():
// Time Complexity: O(nf)
// - Each request is checked against the list sequentially, taking O(f) in the worst case
// - If the request is not found, a new node is appended in O(1)
// - For n requests, this results in O(nf) complexity.

// freqCount():
// Time Complexity: O(nf) in the worst case
// - Each request is searched in O(f) in the worst case
// - If found its frequency is updated and it may need to be repositioned in the list
// - Bubble sort can take up to O(n) in the worst case
// - For n requests, this results in O(nf) complexity

class COMP108Cab {

    public COMP108Node head, tail;

    public COMP108Cab() {
        head = null;
        tail = null;
    }
	
	// O(nf) where n = rSize, f = initial cabinet size
    public COMP108CabOutput appendIfMiss(int rArray[], int rSize) {
        COMP108CabOutput output = new COMP108CabOutput(rSize);

        for (int i = 0; i < rSize; i++) {
            int request = rArray[i];

            COMP108Node current = head;
            boolean found = false;
            int comparisons = 0;

            while (current != null) {
                comparisons++;
                if (current.data == request) {
                    found = true;
                    break;
                }
                current = current.next;
            }

            if (found) {
                output.hitCount++;
            } else {
                output.missCount++;
                COMP108Node newNode = new COMP108Node(request);
                insertTail(newNode);
            }

            output.compare[i] = comparisons;
        }

        output.cabFromHead = headToTail();
        output.cabFromTail = tailToHead();
        return output;
    }

	// O(nf) where n = rSize, f = list size
    public COMP108CabOutput freqCount(int rArray[], int rSize) {
        COMP108CabOutput output = new COMP108CabOutput(rSize);

        for (int i = 0; i < rSize; i++) {
            int request = rArray[i];
            COMP108Node current = head;
            COMP108Node foundNode = null;
            int comparisons = 0;

            while (current != null) {
                comparisons++;
                if (current.data == request) {
                    current.freq++;
                    foundNode = current;
                    output.hitCount++;
                    break;
                }
                current = current.next;
            }

            if (foundNode == null) {
                output.missCount++;
                COMP108Node newNode = new COMP108Node(request);
                insertTail(newNode);
                foundNode = newNode;
            }

            output.compare[i] = comparisons;

            // O(n) where n = rSize
            while (foundNode.prev != null && foundNode.prev.freq < foundNode.freq) {
                COMP108Node prevNode = foundNode.prev;

                // swap previous and found
                prevNode.next = foundNode.next;
                if (foundNode.next != null) foundNode.next.prev = prevNode;
                foundNode.next = prevNode;
                foundNode.prev = prevNode.prev;
                prevNode.prev = foundNode;

                if (foundNode.prev != null) {
                    foundNode.prev.next = foundNode;
                } else {
                    head = foundNode;
                }

                if (prevNode.next == null) {
                    tail = prevNode;
                }
            }

            // if frequency is the same move to the end 
            while (foundNode.next != null && foundNode.next.freq == foundNode.freq) {
                COMP108Node nextNode = foundNode.next;

                // again, swaping previous and found
                foundNode.next = nextNode.next;
                if (nextNode.next != null) nextNode.next.prev = foundNode;
                nextNode.prev = foundNode.prev;
                if (foundNode.prev != null) foundNode.prev.next = nextNode;
                else head = nextNode;
                nextNode.next = foundNode;
                foundNode.prev = nextNode;

                if (foundNode.next == null) {
                    tail = foundNode;
                }
            }
        }

        output.cabFromHead = headToTail();
        output.cabFromTail = tailToHead();
        output.cabFromHeadFreq = headToTailFreq();
        return output;
    }

    // DO NOT change this method
    // insert newNode to head of list
    public void insertHead(COMP108Node newNode) {
        newNode.next = head;
        newNode.prev = null;
        if (head == null)
            tail = newNode;
        else
            head.prev = newNode;
        head = newNode;
    }

    // DO NOT change this method
    // insert newNode to tail of list
    public void insertTail(COMP108Node newNode) {
        newNode.next = null;
        newNode.prev = tail;
        if (tail != null)
            tail.next = newNode;
        else
            head = newNode;
        tail = newNode;
    }

    // DO NOT change this method
    // delete the node at the head of the linked list
    public COMP108Node deleteHead() {
        COMP108Node curr;

        curr = head;
        if (curr != null) {
            head = head.next;
            if (head == null)
                tail = null;
            else
                head.prev = null;
        }
        return curr;
    }

    // DO NOT change this method
    // empty the cabinet by repeatedly removing head from the list
    public void emptyCab() {
        while (head != null)
            deleteHead();
    }

    // DO NOT change this method
    // this will turn the list into a String from head to tail
    // Only to be used for output, do not use it to manipulate the list
    public String headToTail() {
        COMP108Node curr;
        String outString = "";

        curr = head;
        while (curr != null) {
            outString += curr.data;
            outString += ",";
            curr = curr.next;
        }
        return outString;
    }

    // DO NOT change this method
    // this will turn the list into a String from tail to head
    // Only to be used for output, do not use it to manipulate the list
    public String tailToHead() {
        COMP108Node curr;
        String outString = "";

        curr = tail;
        while (curr != null) {
            outString += curr.data;
            outString += ",";
            curr = curr.prev;
        }
        return outString;
    }

    // DO NOT change this method
    // this will turn the frequency of the list nodes into a String from head to tail
    // Only to be used for output, do not use it to manipulate the list
    public String headToTailFreq() {
        COMP108Node curr;
        String outString = "";

        curr = head;
        while (curr != null) {
            outString += curr.freq;
            outString += ",";
            curr = curr.next;
        }
        return outString;
    }
}
