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
// appendIfMiss():
// 	
// freqCount():
// 

class COMP108Cab {

	public COMP108Node head, tail;
	
	public COMP108Cab() {
		head = null;
		tail = null;
	}

	// append to end of list when miss
	public COMP108CabOutput appendIfMiss(int rArray[], int rSize) {
		COMP108CabOutput output = new COMP108CabOutput(rSize);

		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;
	}

	// move the file requested so that order is by non-increasing frequency
	public COMP108CabOutput freqCount(int rArray[], int rSize) {
		COMP108CabOutput output = new COMP108CabOutput(rSize);
		
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
		else head = newNode;
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
		String outString="";
		
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
		String outString="";
		
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
		String outString="";
		
		curr = head;
		while (curr != null) {
			outString += curr.freq;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

}
