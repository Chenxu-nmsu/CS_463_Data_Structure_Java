package lab1;

public class IntNode {

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
		IntNode current = link;
		String result = new String();
		
		while (current != null) {	
			//System.out.println(current.getData());
			result += current.getData(); 
			if (current.getLink() != null) {
				result += "->";
			}
			current = current.getLink();	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
