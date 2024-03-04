package StudentDB;
import java.util.*;
import java.io.*;

public class Main {
	   static Student head;
	   static Scanner sc=new Scanner(System.in);
	   
	  //main function 
    public static void main(String[] args)throws Exception  {
    	
    	     	BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\Deepu\\Full Stack\\output.txt"));
    		    BufferedReader br=new BufferedReader(new FileReader("D:\\Deepu\\Full Stack\\output.txt"));
    	
	            printDash();
	   	        System.out.println("Welcome to Student Database portal");
	            printDash();
		
		do{
			// [TODO]-default function
			// [TODO]-update details function
			// [TODO]-JDBC
			// [TODO]-proper alert msg and spelling mistake
			// [TODO]-phone no type change
			// [TODO]-validation functions in separate file
			
			details();
			System.out.println("Options available");
			System.out.println("1.Add a new Student");
			System.out.println("2.Update the marks");
			System.out.println("3.Delete Student");
			System.out.println("4.Display the Marks");
			System.out.println("5.Exit the Application");
			int choice=sc.nextInt();
			switch(choice){
		    
			case 1:
				System.out.println("Enter student Roll No:");
		      	int rollno=sc.nextInt();
			   	AddStudent(bw,rollno);
			   	break;
			case 2:
				UpdateStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				DisplayDetails(br);
				break;
			case 5:
				System.exit(0); 
				break;
		    default:
		    	System.out.println("Invalid choice");
		    	break;
			}
		}while(true);
	}
    
    //printDash
    public static void printDash() {
    	for(int i=0;i<20;i++) {
    		System.out.print("-");
    	}
    	System.out.println();
    }
    
   //Add student Function 
    public static void AddStudent(BufferedWriter bw , int rollno) {
    	 String name="";
    	 int Year=0; 
    	 int chFe=0;
    	 String Dept="";
    	 int ch=0;
    	 int chQ=0;
    	 float CGPA=0; 
    	 String Address=""; 
    	 String  phone_No=""; 
    	 String Fees_Status="";
    	 String Quota="";
    			 
    	 if(checkUnique(rollno)) {
       	  System.out.println("Sorry :) Student RollNo should be unique");
       	  return;
         }
    	name=Validation.Namevalidation(name);
    	Year=Validation.Yearvalidation(Year);
    	Dept=Validation.Deptvalidation(ch);
    	Fees_Status=Validation.Feesvalidation(chFe);
    	Quota=Validation.Quotavalidation(chQ);
    	CGPA=Validation.CGPAvalidation();
    	Address=Validation.Addressvalidation();
    	phone_No=Validation.phonevalidation();
         
      	  Student student=new Student(rollno,name,Year,Dept,Fees_Status,Quota,CGPA,Address,phone_No);
          // bw.write(student.Student_Name+'\n');
          // bw.flush();
          if(head==null)
    	     head=student;
    	  else {
    		  Student curr=head;
    	    	while(curr.next!=null){
    	    		curr=curr.next;
    	    	}
    	    	curr.next=student;
    	  }
    	}

    //DisplayDetails
   public static void DisplayDetails(BufferedReader br) throws IOException{
      	System.out.println("Enter student Roll No:");
      	int rollno=sc.nextInt();
      	Student curr=head;
    	while(curr!=null) {
    		if(curr.Roll_No==rollno) {
    			printDash();
	   	        System.out.println("Student Details");
	            printDash();
    			System.out.println("Roll No : "+ curr.Roll_No);
    			System.out.println("Name : "+ curr.Student_Name);
             	System.out.println("Year : "+curr.Year);
             	System.out.println("Dept : "+curr.Dept);
             	System.out.println("Fees_Status : "+curr.Fees_Status);
             	System.out.println("Quota : "+curr.Quota);
             	System.out.println("CGPA : "+curr.CGPA);
             	System.out.println("Address : "+curr.Address);
             	System.out.println("phone_No : "+curr.phone_No);
             	printDash();
	   	        System.out.println("\n");

//             	//String line=br.readLine();
//             	while (line != null) {
//    				System.out.println(line);
//    				// read next line
//    				line = br.readLine();
//    			}
//             	br.close();
//             	return;
    		}
    		curr=curr.next;
    	}
    	System.out.println("Student RollNo not found");
    }

  //CheckUnique Function
    public static boolean checkUnique(int rollno){
      	Student curr=head;
    	while(curr!=null) {
        		if(curr.Roll_No==rollno) {
                 return true;
    		}
    		curr=curr.next;
    	}
       return false;
    }
   
  // Delete student function
    public static void deleteStudent(){
    	System.out.println("Enter student Roll No:");
      	int rollno=sc.nextInt();
      	Student curr=head;
      	Student prev=head ;
      	if(head.Roll_No==rollno) {
      		head=head.next;
      		System.out.println("Student Deleted sucessfully");
      	}
      	else {
      		while(curr.next!=null) {
      			if(curr.Roll_No==rollno) {
      				System.out.println("Student Deleted sucessfully");
      				curr=curr.next;
      				prev.next=curr;	
      			}
      				prev=curr;
      				curr=curr.next;
      		}
      	}
      	if(curr==null) {
      		System.out.println("Student Not Found ");
      	}
       }
    
    // update Student function
    public static void UpdateStudent(){
      	System.out.println("Enter student Roll No:");
      	int rollno=sc.nextInt();
      	Student curr=head;
    		
    		if(checkUnique(rollno)){
    			System.out.println("What Details you have to update ?");
         	    System.out.println("\n 1.Student_Name \n2.Year \n3.Dept \n4.Fees_Status \n5.Quota \n6.CGPA \n7.Address \n8.phone_No");
    			int choice=sc.nextInt();
    			
    	    switch(choice) {
    			case 1:
	    			 System.out.println("Exixting Name :"+curr.Student_Name);
	   			     System.out.println("Update Your name");
	   			     String name="";
	   			     name=Validation.Namevalidation(name);
	   			     curr.Student_Name=name;
	   			     break;
    			case 2:
    				 System.out.println("Exixting Year:"+curr.Year);
    			     System.out.println("Update Your Year");
    			     int year=0;
    			     year =Validation.Yearvalidation(year);
    			     curr.Year=year;
    			     break;
    			case 3:
	   				 System.out.println("Exixting Dept :"+curr.Dept);
	   			     System.out.println("Update Your Dept ");
	   			     int ch=0;
	   			     String Dept=Validation.Deptvalidation(ch);
	   			     curr.Dept=Dept;
	   			     break;
    			case 4:
	   				 System.out.println("Exixting Fee_Status :"+curr.Fees_Status);
	   			     System.out.println("Update Your name ");
	   			     int chFe=0;
	   			     String Feestatus=Validation.Feesvalidation(chFe);
	   			     curr.Fees_Status=Feestatus;
	   			     break;
    			case 5:
	   				 System.out.println("Exixting Name :"+curr.Quota);
	   			     System.out.println("Update Your name ");
	   			     int chQ=0;
	   			     String Quota=Validation.Quotavalidation(chQ);
	   			     curr.Quota=Quota;
	   			     break;
    			case 6:
	   				 System.out.println("Exixting Name :"+curr.CGPA);
	   			     System.out.println("Update Your name ");
	   			     float CGPA =Validation.CGPAvalidation();
	   			     curr.CGPA=CGPA;
	   			     break;
    			case 7:
	   				 System.out.println("Exixting Name :"+curr.Address);
	   			     System.out.println("Update Your name ");
	   			     String Address =Validation.Addressvalidation();
	   			     curr.Address=Address;
	   			     break;
    			case 8:
	   				 System.out.println("Exixting Name :"+curr.phone_No);
	   			     System.out.println("Update Your name ");
	   			     String phone_No =Validation.phonevalidation();
	   			     curr.phone_No=phone_No;
	   			     break;
    			}
    		}
    		else {
    			System.out.println("Student RollNo not found");

    	}
    	    }
    
  
public static void details(){
	Student stud1=new Student(1,"Deepthi",1,"Civil","paid","Govt",(float) 5.6,"kanniah st","1234512345");
	if(head==null) {
		head =stud1;
	}else {
		head.next=stud1;
	}
}
}