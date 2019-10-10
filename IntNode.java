package lab1;

public class IntNode {
	
	// Lab 4
	// (1) two instance variable
	int data; 
	IntNode link; 
	
	// (2) No-argument constructor
	public IntNode() {
		data = 0;
		link = null;
	}
	
	// (3) Constructor with the given node value and the link
	public IntNode (int _data, IntNode _node){
		data = _data;
		link = _node;
	}
	
	// (4) get and set methods
	//return the data from this node
	public int getData() {
		return data;
	}
	
	//return a reference to the node after this node
	public IntNode getLink() {
		return link;
	}
	
	public void setData(int newdata) {
		data = newdata;
	}
	
	public void setLink(IntNode newLink) {
		link = newLink;
	}
	
	// (5) toString method
	public String toString() {
		String result = new String();
		result = data + "->";
		IntNode current = link;
		while(current != null) {
			result += current.getData();
			if (current.getLink() != null) {
				result += "->";
			}
			current = current.link;
		}
		return result;
	}
		
	// (6) a method to add a node after the current node
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}
	
	// (7) remove the node after the current node
	public void removeNodeAfterThis() {
		link = link.link;
	}
	
	// (8) get the number of nodes in the list starting from a given node head
	public static int listLength(IntNode head) {
		int answer = 0;
		IntNode cursor;
		
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer ++;
		return answer;
	}
	
	// (9) search whether a linked list starting with head contains a given value data
	// Prediction: head is not null; 
	public static boolean search(IntNode head, int data) {
		IntNode cursor;
		boolean result = false;
		
		for (cursor = head; cursor != null; cursor = cursor.link) {
			if (data == cursor.data) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	
	//------------------------------------------
	// Lab 5 
	// (1) A method to calculate the number of even elements in the linked list
	public static int listEvenNumber(IntNode head) {
		IntNode cursor;
		int num = 0;
		
		if (head == null) {
			num = 0;
		}
		
		// loop for every node and determine the data is even or not.
		for (cursor = head.link; cursor != null; cursor = cursor.link) {
			if (cursor.data % 2 == 0) {
				num ++;
			}
		}
		return num;
	}
	
	
	public void add(int newdata) {
		IntNode head = link;
		IntNode newNode = new IntNode (newdata, null);
		//System.out.println(head.data);
		if(head == null) {
			head = newNode;
			
			//System.out.println(head.data);
		}
		
	}
	
	// (2) A method to add the given newdata to the end of the linked list that starts from the current node.	
	public void addToEnd(int newdata) {
		IntNode head = link;
		IntNode newNode = new IntNode (newdata, null);
		
		if (head == null) {	
			head = newNode;
			System.out.println(head.data);
			return;
		}
		else {
			IntNode last = head;
			while (last.link != null) {
				last = last.link;
			}
			last.link = newNode;
			return;
		}
	}
	
	// (3) Calculate the summation of elements in the last num nodes in a given linked list.
	// Precondition: the maximum number of node to sum is the len of the linked list.
	public static int sumLast(IntNode head, int num) {
		if (num <= 0) {
			return 0;
		}
		
		int sum = 0; 
		int len = 0;
		IntNode current = head;
		
		while (current != null) {
			len = len + 1;
			current = current.link;
		}
		
		// the maximum number is the length of the linked list. 
		if (num > len) {
			num = len;
		}
		
		// define the start location.
		int c = len - num;
		current = head;
		
		// reach the specific location.
		while (c > 0) {
			current = current.link;
			c = c - 1;
		}
		
		while (current !=null) {
			sum = sum +current.data;
			current = current.link;
		}
		return sum;
	}
	
	// (4) Copy part of a given linked list.
	public static IntNode copyOdd (IntNode head) {
		IntNode oddList;
		if (head == null) {
			return null;
		}
		
		// create an oddList to store the nodes with odd numbers
		oddList = new IntNode();
		while (head != null) {
			if (head.data % 2 != 0) {
				oddList.addNodeAfterThis(head.data);
			}
			head = head.link;
		}
		return oddList.link;     // remove the first node.
	}

	// (5) A method to remove ALL the nodes that have the data value e from the linked list starting from the given head.
	public static IntNode removeAll(IntNode head, int e) {
		if (head == null) {
			return null;
		}
		
		// create a newList to store all node with data not equal to e.
		IntNode newList = new IntNode();

		while (head != null) {			
			if (head.data != e) {
				newList.addNodeAfterThis(head.data);
			}
			head = head.link;
		}
		return newList.link;
	}
	
	// (6) A method to reverse a linked list.
	public static IntNode reverse (IntNode head) {
		IntNode current, prev, next;
		current = head;
		prev = null;
		next = null;
		
		while (current != null) {
			next = current.link;
			current.link = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
	
	// (7) A method to test whether a linked list starting from the given head is cyclic or acyclic.
	public static boolean hasCycle(IntNode head) {
		IntNode fast = head;
		IntNode slow = head;
		while (fast != null && fast.link != null) {
			fast = fast.link.link;
			slow = slow.link;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

