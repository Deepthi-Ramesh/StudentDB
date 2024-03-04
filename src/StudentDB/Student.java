package StudentDB;

public class Student {
     int Roll_No;
     String Student_Name;

    int Year; 
    String Dept;
    String Fees_Status;
    String Quota;
    float CGPA ;
    String Address;
    String phone_No;
     Student next;
     
public Student(int Roll_No,String Student_Name, int Year , String Dept , String Fees_Status ,String Quota , float CGPA , String Address,String phone_No) {
		     this.Roll_No=Roll_No;
		     this.Student_Name=Student_Name;
	         this.Year=Year;
	         this.Dept=Dept;
	         this.Fees_Status=Fees_Status;
	         this.Quota=Quota;
	         this.CGPA =CGPA;
	         this.Address=Address;
	         this.phone_No=phone_No;
		   
		     this.next=null;
		 }

}
