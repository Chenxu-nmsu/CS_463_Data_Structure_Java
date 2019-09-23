package lab1;

import java.util.Arrays;

public class Employee{

	//declaration of instance variables
	private String name;
	private int no;
	private int age;
	private String state;
	private int zip;
	private int[] advisors;
		
	//(1) No-argument Constructor
	public Employee() {
		name=null;
		no=0;
		age=0;
		state=null;
		zip=0;
		advisors=null;
	}
	
	//(2) copy constructor
	public Employee (Employee employee){
		if (employee==null) return;
		if (employee instanceof Employee) {
			name=employee.name;
			no=employee.no;
			age=employee.age;
			state=employee.state;
			zip=employee.zip;
			advisors=employee.advisors;
		}
	}
	
	//(3) get and set methods
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	//no
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no=no;
	}
	
	//age
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}	
	
	//state
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	
	//zip
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip=zip;
	}
	
	//advisor
	public int[] getAdvisors() {
		return advisors;
	}
	public void setAdvisors(int... advisors) {
		this.advisors=advisors;
	}
	
	//(4) toString method
	public String toString() {
		String result = new String();
		String info = name +"\t\t"+ no +"\t\t"+  age +"\t\t"+  state +"\t\t"+  zip +"\t\t";
		String tmp = new String();
		
		//add the element in advisor[] one by one since the array cannot print out correctly.
		for (int i=0; i < advisors.length; i++) {
			tmp = tmp + advisors[i] + ",";
		}
		
		result = info + tmp;		
		return result;
	}	
	
	//(5) equal method 
	public boolean equals (Object employee) { 
		boolean result = false;
		
		//initialize the given employee
		Employee given = (Employee) employee;
		
		if (employee != null && employee instanceof Employee) {
			result = (no == given.no);		
		}
		return result;
	}
	
	
	//(6) A static method getAllAdvisors	
	public static int[] getAllAdvisors(Employee e1, Employee e2){ 
		int total[]=new int[e1.advisors.length + e2.advisors.length];
		
		//put all the advisors in total
		for (int i=0; i <= e1.advisors.length - 1; i++) {
			total [i] = e1.advisors[i];
			}
		for (int i=0; i <= e2.advisors.length - 1; i++) {
			total [e1.advisors.length+i] = e2.advisors[i];
			}
		
		//compare the element one by one, use end to record the number of different advisors.
		int end = total.length;
		for (int i=0; i < end; i++) {
			for (int j = i+1; j < end; j++) {
				if (total[i] == total[j]) {
					total[j]=total[end-1];
					end--;
					j--;
				}
			}
		}
		
		// initialize the result to restore the distinct advisors
		// the size of the new array is updated with the end value.
		int[] result = new int[end];
		for (int i=0; i<end; i++) {
			result[i]=total[i];
		}					
		return result;
	}	 
	
	//main(method)
	public static void main(String[] args) {
		
		//create three employees
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		
		e1.setName("Brown");
		e1.setNo(112);
		e1.setAge(20);
		e1.setState("MA");
		e1.setZip(1450);
		e1.setAdvisors(200,201,202);
		
		e2.setName("Murry");
		e2.setNo(112);
		e2.setAge(21);
		e2.setState("TX");
		e2.setZip(78230);
		e2.setAdvisors(202,203);
		
		e3.setName("Del");
		e3.setNo(113);
		e3.setAge(23);
		e3.setState("AZ");
		e3.setZip(85006);
		e3.setAdvisors(204);
		
		//show the input data
		System.out.println("Input data:");
		System.out.println("Name\t\tNo.\t\tAge\t\tState\t\tZip\t\tAdvisors");
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e3.toString());
		System.out.println();
		
		//result of equals method result
		System.out.println("Compare the employee number between two employees:");
		System.out.println(e1.equals(e2));
		System.out.println();
		
		//result of the DISTINCT advisors of two employees
		//specify the two employees
		System.out.println("Distinct advisors between two employees:");
		System.out.println(Arrays.toString(getAllAdvisors(e1, e2)));
	}
	}