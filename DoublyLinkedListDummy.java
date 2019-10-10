package lab1;

public class DoublyLinkedListDummy {

	// Q1: two instance variables.
	private DIntNode head;
	private DIntNode tail;
	private int manyItems;
	
	// Q2: Getter and Setter methods.
	// getHead() method
	public DIntNode getHead() {
		 return head;
	}
	
	// getTail() method
    public DIntNode getTail() {
    	 return tail;
    }
    
    // setHead() method
    public void setHead(DIntNode node) {
    	 head = node;
    }
    
    // setTail() method
    public void setTail(DIntNode node) {
    	 tail = node;
    }
	
	// Q3: no-argument constructor.
	public DoublyLinkedListDummy() {
		
		// create dummy nodes
		head = new DIntNode();
		tail = new DIntNode();
		
		// link dummy nodes together
		head.setNext(tail);
		tail.setPrev(head);
		
		manyItems = 0;
	}
	// Q4: addEnd() method.
	/**
	* add an element from the end of the list.
	* The time complexity is O(1), only one iteration.
	* @param element
	* 	  a node with data of element needs to be added in the end.
	* @return
	*     the new list with adding a node of element.
	**/
	 public void addEnd(int element) {
	 	DIntNode newNode = new DIntNode(element);
	 	DIntNode cursor = tail.getPrev();
	 	
	 	cursor.setNext(newNode);
	 	newNode.setPrev(cursor);
	 	newNode.setNext(tail);
	 	tail.setPrev(newNode);
	}
	 
	// Q5: removeFromHead() method.
	/**
	*  remove the first actual node (i.e., the node that the dummy head points to).
	* The time complexity is O(1), only one iteration.
	* @return
	*     the new list without the first actual node.
	**/
	public void removeHead() {
		DIntNode removeHead = head;
		if (removeHead != null) {
			removeHead.getNext().setPrev(null);
			head = removeHead.getNext();
		}
	}

	// Q6: toString() method.
	public String toString() {
		String result = new String();
		DIntNode cursor;
		
		// get head-to-tail list
		result = result + "(Forward) ";
		cursor = head.getNext();
		
		while (cursor != tail) {
			result = result + cursor.getData();
			if (cursor.getNext() != tail) {
				result += "<->";
			}
			cursor = cursor.getNext();
		}
		
		// get tail-to-head list
		result = result + "\n(Backward) ";
		cursor = tail.getPrev();
		
		while (cursor != head) {
			result = result + cursor.getData();
			if (cursor.getPrev() != head) {
				result += "<->";
			}
			cursor = cursor.getPrev();
		}		
		return result;
	}
	
	// Q7: countOccurrence(int e) method.
	/**
	* compute the number of times that the given value e occurs in nodes in this linked list.
	* The worst case time complexity is O(n), where n is the number of elements in the original list.
	* @param e
	*     The integer value to search.
	* @return
	*     the number of times for e.
	**/	
	public int countOccurrence(int e) {
		DIntNode cursor;
		int count = 0;
		for (cursor = head; cursor != null; cursor = cursor.getNext()) {
			if (cursor.getData() == e) {
				count = count + 1;
			}		
		}
		return count;
	}
	
	// Q8: removeAll() method.
	/**
	* remove all the nodes that contain element e from the list. 
	* The worst case time complexity is O(n), where n is the number of elements
	* in the original list.
	* @param e
	*     The integer value to remove.
	* @return
	*     true or false, indicating the node with value of e is removed or not.
	**/	
	public boolean removeAll(int e) {
		DIntNode cursor = head.getNext();
		boolean result = false;
		
		for (cursor = head; cursor != null; cursor = cursor.getNext()) {
			if (cursor.getData() == e) {
				DIntNode prev = cursor.getPrev();
				DIntNode next = cursor.getNext();
				prev.setNext(next);
				next.setPrev(prev);
				result = true;
			}		
		}
		return result;
	}
	
	// Q9: subList() method.
	/**
	* Extract a sublist from the current list. The worst case
	* time complexity is O(n), where n is the number of elements
	* in the original list.
	* @param beginIdx
	*     The integer index of the first element of the new list.
	* @param endIdx
	*     The integer index after the last element of the new list.
	* @precondition
	*     beginIdx is no less than 0
	* @precondition
	*     beginIdx is no greater than the size of this list
	* @precondition
	*     beginIdx is no greater than endIdx
	* @return
	*     A new doubly-linked list that is a copy of the portion of the current
	*     list given by beginIdx and endIdx.
	**/	
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx) {
		DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
		DIntNode cursor;
		int i=-1;
		
		for (cursor = head.getNext(); cursor != null; cursor = cursor.getNext()) {
			i++;
			if (i >= beginIdx && i < endIdx) {
				newList.addEnd(cursor.getData());
			}		
		}
		return newList;
	}
	
	// Q10: printStatistics()
	/**
	* print a brief summary of this list. The worst case
	* time complexity is O(n^2), where n is the number of elements
	* in the original list.
	* @return
	* print out the data of distinct nodes and corresponding occurrence in the original list.
	**/
	public void printStatistics(){
		DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
		DIntNode cursor1 = this.getHead().getNext();
		DIntNode cursor2 = null;
		newList.addEnd(cursor1.getData());
		
		// create a new double linked list to restore the distinct nodes in the original double linked list.
		for (cursor1 = cursor1.getNext(); cursor1 != tail; cursor1 = cursor1.getNext()) {
			
			// use result to tell whether the nodes in the newList is the same as those in the original double linked list.
			boolean result = true;
			cursor2 = newList.getHead().getNext();
			while(cursor2 !=  null) {
				if (cursor1.getData() == cursor2.getData()) {
					result = false;
				}
				cursor2 = cursor2.getNext();
			}
			if (result == true) {
				newList.addEnd(cursor1.getData());
			}	
		}
		
		System.out.println("Double Linked list without repetative numbers: ");
		System.out.println(newList.toString());
		
		// reach each node in the newList and count the occurrence for each data.
		DIntNode cursor3 = newList.getHead().getNext();
		System.out.println("number occurrence");
		while (cursor3 != newList.getTail()) {
			System.out.println(String.format("  " + "%-5s", cursor3.getData()) + " " + String.format("%4s", this.countOccurrence(cursor3.getData())));
			cursor3 = cursor3.getNext();
		}
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Q11: Test cases: initialize a double linked list with dummy head and tail (test).
		DoublyLinkedListDummy test = new DoublyLinkedListDummy();
		test.addEnd(10);
		test.addEnd(20);
		test.addEnd(30);
		
		// Test for toString() method
		System.out.println("### Test for toString() method ###");
		System.out.println(test.toString());
		System.out.println();
		
		// Test for addEnd() method
		System.out.println("### Test for addEnd() method ###");
		System.out.println("Original list:");
		System.out.println(test.toString());
		test.addEnd(40);
		System.out.println("Add 40 in the end:");
		System.out.println(test.toString());
		System.out.println();
		
		// Test for removeHead() method
		System.out.println("### Test for removeHead() method ###");
		System.out.println("Original list:");
		System.out.println(test.toString());
		test.removeHead();
		System.out.println("Add removing head:");
		System.out.println(test.toString());
		System.out.println();
		
		// initialize a double linked list with dummy head and tail (test2).
		DoublyLinkedListDummy test2 = new DoublyLinkedListDummy();
		test2.addEnd(1);
		test2.addEnd(3);
		test2.addEnd(7);
		test2.addEnd(1);
		
		// Test for countOccurence() method
		System.out.println("### Test for countOccurence() method ###");
		System.out.println("Original list:");
		System.out.println(test2.toString());
		System.out.println("countOccurrence(1): " + test2.countOccurrence(1));
		System.out.println("countOccurrence(2): " + test2.countOccurrence(2));
		System.out.println("countOccurrence(3): " + test2.countOccurrence(3));
		System.out.println();
		
		// Test for removeAll() method
		System.out.println("### Test for removeAll() method ###");
		System.out.println("Original list:");
		System.out.println(test2.toString());
		System.out.println("Execute removeAll(1): " + test2.removeAll(1));
		System.out.println("Current test2: \n" + test2);
		System.out.println();
		
		// initialize a double linked list with dummy head and tail (test3).
		DoublyLinkedListDummy test3 = new DoublyLinkedListDummy();
		test3.addEnd(1);
		test3.addEnd(2);
		test3.addEnd(3);
		test3.addEnd(4);
		test3.addEnd(5);
		test3.addEnd(6);
		test3.addEnd(7);
		
		// Test for subList() method
		System.out.println("### Test for subList() method ###");
		System.out.println("Original list: \n" + test3.toString());
		System.out.println("subList [0, 5]: \n" + test3.subList(0, 5));
		System.out.println();
		
		// initialize a double linked list with dummy head and tail (test4).
		DoublyLinkedListDummy test4 = new DoublyLinkedListDummy();
		test4.addEnd(1);
		test4.addEnd(2);
		test4.addEnd(3);
		test4.addEnd(2);
		test4.addEnd(1);
		test4.addEnd(3);
		test4.addEnd(3);
		test4.addEnd(7);
		test4.addEnd(10);
		
		// Test for printStatistics() method
		System.out.println("### Test for printStatistics() method ###");
		System.out.println("Original list: \n" + test4.toString());
		System.out.println("Statistical result: ");
		test4.printStatistics();
	}

}
