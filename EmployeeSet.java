package lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeSet {			
	
	//Employee class
    public static class Employee{
	String name;
	int no;
	int age;
	String state;
	int zip;
	String sex;
	
		//Employee Constructor 
		public Employee(){
		    name=null;
		    no=0;
		    age=0;
		    state=null;
		    zip=0;
		    sex=null;
		}
    } 
	
	//1.create instance variables to keep distinct employee objects and the actual number of employees.
    int manyItems;       //number of elements in the array
	public Employee[] employee=null;
	
	//2.no-argument constructor
	public EmployeeSet() {
		final int capacity = 10;
		employee = new Employee [capacity];
		for (int i=0; i < capacity; i++) {
			employee[i] = new Employee();
		}
	}
		
	//3.copy constructor
	public EmployeeSet (Object obj){
		if (obj != null && obj instanceof Object) {
			EmployeeSet data1 = (EmployeeSet) obj;
			this.manyItems = data1.manyItems;
			this.employee = new Employee [data1.employee.length];
			for (int i=0; i < data1.capacity(); i++) {
				this.employee[i] = data1.employee[i];
			}
		}				
	}
		
	//4.return the actual number of elements
	public int size() {
		manyItems = 0;
		//System.out.println(employee.length);
		for (int i=0; i < employee.length; i++) {		
			
			if (employee[i].name != null) {
				manyItems ++;
			}	
		}
		return manyItems;
	}
	
	//5.return the capacity of this collection instance
	public int capacity() {
		return employee.length;
	}
	
	//6.add employee object
	public void add(Employee a) {
		if (a != null) {
			if (manyItems == employee.length) {
			ensureCapacity(manyItems*2);
			}
			employee[manyItems] = a;
			manyItems++;
		}	
	}
		
	//7.check the collection contains a or not? Just check the no for each employee
	public boolean contains (Employee a) {
		boolean result = false;
		if (a == null) {
			result = false;
			}
		if (a != null) {
			for (int i=0; i < manyItems; i++) {
				if (employee[i].no == a.no) {
					result = true;
					break;
				}
			
			}
		}
		return result;
	}
	
	
	
	//8.remove employee from the collection
	public boolean remove (int eno) {
		int index = 0;
		
		if (employee == null) return false;
		if (employee != null) {			
			while ((index < manyItems) && (eno != employee[index].no))
					index++;
			}
		
		if (index == manyItems)
			return false;
		else {
			manyItems--;
			employee[index] = null;
			return true;
		}										
	}
	
	//9.ensure the capacity
	public void ensureCapacity(int minimumCapacity) {
		
		Employee [] biggerArray;
		
		if (employee.length <= minimumCapacity) {
			biggerArray = new Employee[minimumCapacity];
					
			System.arraycopy(employee, 0, biggerArray, 0, manyItems);
			employee = biggerArray;
			for (int i = employee.length/2;i < minimumCapacity;i++){
			    employee[i]=new Employee();
			    }		
		}
	}
	
	//10.add the employee in ascending order of employee nos
	public void addOrdered (Employee a) {
		
		if (manyItems == employee.length) {
			
			//print the actual employee numbers
			//System.out.println(manyItems * 2);
			ensureCapacity (manyItems * 2);
			
		}
				
		if (employee != null) {
			for (int i=0; i < manyItems-1; i++) {
				if (a.no < employee[i].no) {
					for (int j = manyItems; j > i; j-- ) {
						employee [j] = employee[j-1];
					}
					employee[i] = a;
					break;
				}
				else {
					employee[manyItems] = a;
				}
				}
			}
		}
	
	
	//11.main function
	public static void main(String[] args) {
		
		//create the data and read the file from the given core_dataset.csv file
		EmployeeSet data = null;
		data = new EmployeeSet();
		
		int no = 0;
		String line = "";
		
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader("core_dataset.csv");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
        	
            while((line = bufferedReader.readLine()) != null) {
            	String[] lineStr = line.split(","); 
            	
            	if(no == 1){                	                	                              	
                	data.employee[no-1]= new Employee();
                	data.employee[no-1].name = lineStr[0]+lineStr[1];
                	data.employee[no-1].no = Integer.parseInt(lineStr[2]);
                	data.employee[no-1].state = lineStr[3];
                	data.employee[no-1].zip = Integer.parseInt(lineStr[4]);
                	data.employee[no-1].age = Integer.parseInt(lineStr[6]);
                	data.employee[no-1].sex = lineStr[7];
                	
                	// add the first employee into the data
                	data.add(data.employee[no-1]);
               
            	}
            	
            	if (no > 1) {
            		data.employee[no-1]= new Employee();
                	data.employee[no-1].name = lineStr[0]+lineStr[1];
                	data.employee[no-1].no = Integer.parseInt(lineStr[2]);
                	data.employee[no-1].state = lineStr[3];
                	data.employee[no-1].zip = Integer.parseInt(lineStr[4]);
                	data.employee[no-1].age = Integer.parseInt(lineStr[6]);
                	data.employee[no-1].sex = lineStr[7];
            		
                	// tell the size of the data and the length of employee[] 
                	// try to trace the change of data.size and employee.length
                	System.out.println();
                	System.out.println(data.size());
                	System.out.println(data.employee.length);
                	
                	// compare the added employee.no with the existing employees no and set the ascending order
                	data.addOrdered(data.employee[no-1]);   
            	}	
            	no++;
                }     
               
            bufferedReader.close(); // Always close files.         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  "core_dataset.csv" + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + "core_dataset.csv" + "'");                  
        }
		
		//print all the employee elements in the array in ascending order
		//add one element each time and insert it in the right space
		for(int i=0; i < data.size()-1; i++) {
			System.out.println(data.employee[i].name+","+data.employee[i].no+","+data.employee[i].state+","+data.employee[i].zip+","+data.employee[i].age+","+data.employee[i].sex);
		}
		
		//4. test size() method
		System.out.println();
		System.out.println("#Test size() method");
		System.out.println(data.size());
		
		//5. test capacity() method
		System.out.println();
		System.out.println("#Test capacity() method");
		System.out.println(data.capacity());
		
		//6. test add() method
		System.out.println();
		System.out.println("#Test add() method");
		System.out.println("Successfully test during the read file process");
		
		//7. test contain() method
		//initialize the e1 as the same with the first element in dataSet.
		Employee e1 = new Employee();
		e1.name = "\"Lindsay Leonara \"";
		e1.no = 602000312;
		e1.state = "CT";
		e1.zip = 6070;
		e1.age = 29;
		e1.sex = "Female";
		
		//initialize the e2 as a unique element as compared with the elements in the dataSet
		Employee e2 = new Employee();
		e2.name = "Lindsay Leonara ";
		e2.no = 602000000;          //only change the e2.no
		e2.state = "CT";
		e2.zip = 6070;
		e2.age = 29;
		e2.sex = "Female";
		
		System.out.println();
		System.out.println("#Test contain() method");
		System.out.println(data.contains(e1));    //The result is true
		System.out.println(data.contains(e2));	  //The result is false
		
		//8. test remove method
		System.out.println();
		System.out.println("#Test remove() method");

		int eno1 = 602000312;		
		System.out.println(data.employee[0].name);
		System.out.println(data.remove(eno1));
		System.out.println(data.employee[0]);
		System.out.println("The first element in the data has been removed successfully");
		
		//9. test ensureCapacity method
		System.out.println();
		System.out.println("#Test ensureCapacity() method");
		System.out.println("Successfully tested in add() and addOrdered() method");
	}
}