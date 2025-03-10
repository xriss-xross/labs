//
// Enter your name: Killian Ferdinand Carolan
// Enter your student ID: 201823073
//

class COMP108W07 {

	public Node head, tail;
	
	public COMP108W07() {
		head = null;
		tail = null;
	}

	// sequential search if key is in the list
	// return true or false accordingly
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public boolean seqSearchList(int key) {
		boolean found = false;
		Node node = head;
		
		while (!found && node.next != null) {
			if (node.data == key) {
				found = true;
			} else {
				node = node.next;
			}
		} if (!found) {
			if (node.data == key) {
				found = true;
			}
		}

		return found;		
	}

	// sequential search to count how many times key appears is in the list
	// return the count
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public int countList(int key) {
		int count=0;
		Node node = head;

		while (node.next != null) {
			if (node.data == key) {
				count ++;
			}
			node = node.next;

		} if (node.data == key) {
				count ++;
		}
		
		return count;
	}

	// finding the minimum number in the list
	// return the minimum
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public int searchMin() {
		int min=Integer.MAX_VALUE;
		Node node = head;

		while (node.next != null) {
			if (node.data < min) {
				min = node.data;
			}
			
			node = node.next;
		}
		// still want to check the node tail
		if (node.data < min) {
			min = node.data;
		}

		return min;
	}

	// finding the maximum number in the list
	// return the maximum
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public int searchMax() {
		int max=Integer.MIN_VALUE;
		Node node = head;
		while (node.next != null) {			
			if (node.data > max) {
				max = node.data;
			}
			node = node.next;
		}
		// still want to check the node tail
		if (node.data > max) {
			max = node.data;
		}

		return max;
	}

	// DO NOT change this method
	// insert newNode to the head of the list
	public void insertHead(Node newNode) {
		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// insert newNode to the tail of the list
	public void insertTail(Node newNode) {
		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	// DO NOT change this method
	// this will turn the list into a String from head to tail
	// This is only here to ease outputing the list content.
	// You should not use it in your list traversal.
	public String headToTail() {
		Node curr;
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
	// This is only here to ease outputing the list content.
	// You should not use it in your list traversal.
	public String tailToHead() {
		Node curr;
		String outString="";
		
		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}

}
