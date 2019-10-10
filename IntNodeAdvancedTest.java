package lab1;

public class IntNodeAdvancedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initiate a linked list (12->17->3->0->34)
		IntNode list = new IntNode(12, null);
		list.addNodeAfterThis(34);		
		list.addNodeAfterThis(0);		
		list.addNodeAfterThis(3);
		list.addNodeAfterThis(17);
		System.out.println("Given linked list: " + list.toString());
		
		// 1. Test for listEvenNumber() method
		System.out.println();
		System.out.println("#1 Test for listEvenNumber() method");    // case for the given list.
		System.out.println("Result for the given list: " + IntNode.listEvenNumber(list));
		IntNode list1 = new IntNode();                                // case for the head=null.
		System.out.println("Result for the null list: " + IntNode.listEvenNumber(list1));
		
		// 2. Test for addToEnd() method
		System.out.println();
		System.out.println("#2 Test for addToEnd() method");
		System.out.println("Given linked list: ");
		System.out.println(list.toString());     
		list.addToEnd(10);
		System.out.println("After adding a node with data of 10:");
		System.out.println(list.toString());
		System.out.println("Case for head = null:");
		IntNode list2 = new IntNode();   // case for the head = null.
		list2.addToEnd(10); 
		
		// 3. Test for sumLast() method
		System.out.println();
		System.out.println("#3 Test for sumLast() method");
		System.out.println(list.toString());
		int num1 = 1;
		System.out.println("Sum of last "+ num1 + " nodes = " + IntNode.sumLast(list, num1));
		int num2 = 2;
		System.out.println("Sum of last "+ num2 + " nodes = " + IntNode.sumLast(list, num2));
		int num3 = 7;    // case for num > len.
		System.out.println("Sum of last "+ num3 + " nodes = " + IntNode.sumLast(list, num3));
		
		// 4. Test for copyOdd() method
		System.out.println();
		System.out.println("#4 Test for copyOdd() method");
		System.out.println("Given linked list:");
		System.out.println(list.toString());
		System.out.println("After coping the odd nodes: ");
		System.out.println(IntNode.copyOdd(list));
		
		System.out.println("Case for null linked list: ");
		IntNode list4 = new IntNode(); 
		System.out.println(IntNode.copyOdd(list4));
		
		// 5. Test for removeAll() method
		System.out.println();
		System.out.println("#5 Test for removeAll() method");
		System.out.println("Given linked list:");
		System.out.println(list.toString());
		System.out.println("After removing nodes: ");
		System.out.println(IntNode.removeAll(list, 12));
		
		// 6. Test for reverse() method
		System.out.println();
		System.out.println("#6 Test for reverse() method");
		System.out.println("Given linked list:");
		System.out.println(list);
		System.out.println("After reversing the nodes:");
		System.out.println(IntNode.reverse(list));
		
		// 7. Test for hasCycle() method
		System.out.println();
		System.out.println("#7 Test for hasCycle() method");
		System.out.println("(1) Case for acyclic linked list");
		IntNode list7 = new IntNode(34, null);
		list7.addNodeAfterThis(0);		
		list7.addNodeAfterThis(3);		
		list7.addNodeAfterThis(12);
		System.out.println("Test case: " + list7.toString());
		System.out.println(IntNode.hasCycle(list7));
		
		System.out.println("(2) Case for cyclic linked list");
		IntNode list8 = new IntNode(34, null);	
		IntNode second = new IntNode(12, null);
		IntNode third = new IntNode(3, null);
		IntNode fourth = new IntNode(0, null);
		list8.link = second;
		second.link = third;
		third.link = fourth;
		fourth.link = list8;
		System.out.println("Test case: " + list8.data + "->" + list8.link.data + "->" + list8.link.link.data + "->" + list8.link.link.link.data);
		System.out.println(IntNode.hasCycle(list8));
		
	}
}
