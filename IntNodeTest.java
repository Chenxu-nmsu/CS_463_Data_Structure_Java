package lab1;

public class IntNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initiate a linked list as listed in the handout (12->28->0->34)
		// Test for addNodeAfterThis() method
		IntNode list = new IntNode();		
		list.addNodeAfterThis(34);		
		list.addNodeAfterThis(0);		
		list.addNodeAfterThis(28);		
		list.addNodeAfterThis(12);

		// Test for toString() method
		System.out.println();
		System.out.println("# Test for toString() method");
		System.out.println("The linked list starting from the node is: ");
		System.out.println(list.toString());		
		System.out.println("The linked list starting from the given node is: ");
		System.out.println(list.getLink().getLink().toString());		
	
		// Test for removeNodeAfterThis() method
		System.out.println();
		System.out.println("# Test for removeNodeAfterThis() method");
		System.out.print("Original list: ");
		System.out.println(list.toString());
		System.out.print("list after removing: ");   
		list.removeNodeAfterThis();       // remove 12
		System.out.println(list.toString());
		
		// Test for listLength(IntNode head) method
		System.out.println();
		System.out.println("# Test for listLength(IntNode head) method");
		System.out.print("The length of the list is: ");
		System.out.println(IntNode.listLength(list));
		
		// Test for search(IntNode head, int data) method
		System.out.println();
		System.out.println("# Test for search(IntNode head, int data) method");
		System.out.println("The int data exists or not (true or false): ");
		System.out.print("Case for 28: ");
		System.out.println(IntNode.search(list, 28));     // true case
		System.out.print("Case for 1: ");
		System.out.println(IntNode.search(list, 1));      // false case
	}

}
