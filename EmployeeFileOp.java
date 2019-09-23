package lab1;

import java.io.*;

class mypair{
	String name; 
	String num;
	String state;
	String zip;
	String age;
	String sex;
}

public class EmployeeFileOp {
	
	private static mypair[] numberpairs = null;
	
	public static void read(String fname){
		int no = 0; 
		String line = "";
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            int totalNumber = 302;
        	numberpairs = new mypair[totalNumber];
        	
            while((line = bufferedReader.readLine()) != null) {
            	String[] lineStr = line.split(","); 
            	
            	if(no==0){                	                	              
                	
                	numberpairs[no]= new mypair();
                	numberpairs[no].name = lineStr[0];
                	numberpairs[no].num = lineStr[1];
                	numberpairs[no].state = lineStr[2];
                	numberpairs[no].zip = lineStr[3];
                	numberpairs[no].age = lineStr[5];
                	numberpairs[no].sex = lineStr[6];
                }else{
                	                              	
                	numberpairs[no]= new mypair();
                	numberpairs[no].name = lineStr[0]+lineStr[1];
                	numberpairs[no].num = lineStr[2];
                	numberpairs[no].state = lineStr[3];
                	numberpairs[no].zip = lineStr[4];
                	numberpairs[no].age = lineStr[6];
                	numberpairs[no].sex = lineStr[7];
                                	
                }
                no++;
            }   
            bufferedReader.close(); // Always close files.         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
		//print out
		for(int i=0; i < 302; i++) {
			System.out.println(numberpairs[i].name+","+numberpairs[i].num+","+numberpairs[i].state+","+numberpairs[i].zip+","+numberpairs[i].age+","+numberpairs[i].sex+"\n");
		}
	}
	
	
	public static void write(String fname){
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(numberpairs[0].name+","+numberpairs[0].num+","+numberpairs[0].state+","+numberpairs[0].zip+","+numberpairs[0].age+","+numberpairs[0].sex+"\n");			
			
			for(int i=1;i<numberpairs.length;i++){				
							
				if (Integer.parseInt(numberpairs[i].age)<= 30)
				{		
				bw.write(numberpairs[i].name+","+numberpairs[i].num+","+numberpairs[i].state+","+numberpairs[i].zip+","+numberpairs[i].age+","+numberpairs[i].sex+"\n");
				}
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing pairs to file "+ fname);
	}
	
	public static void main(String[] args) {
		
		numberpairs = null;		
		read("core_dataset.csv");		
		write("young_employee.csv"); 
	}

}
