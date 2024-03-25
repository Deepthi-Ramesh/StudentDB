package StudentDB;
import java.util.*;

public class Validation{
	  static Scanner sc=new Scanner(System.in);
	  
		public static String Namevalidation(String Name) {
		    while(Name=="") {      	
		        try {
		     	   System.out.println("Enter Student Name :");
		   	        Name=sc.next();
		          }
		        catch(InputMismatchException e) {
		     	   System.out.println("Please enter Correct type");
		     	   sc.nextLine();
		        }
		   }
			return Name ;
		}
		
		public static int Yearvalidation(int Year) {
			while(Year==0) {
			    try {
			 	   System.out.println("Enter student Year:\n1 \n2 \n3 \n4");
				       Year=sc.nextInt();
			      }
			    catch(InputMismatchException e) {
			 	   System.out.println("Please enter Correct type");
				       sc.nextLine();
			      }
			    }
			return Year ;
		}
		public static String Deptvalidation(int ch) {
			  String Dept="";
			 while(ch==0){
				    try {
				 	   System.out.println("Enter Student Dept:\n 1.Civil 2.Mech 3.ECE 4.EEE 5.CSE 6.IT 7.Others");
				        ch =sc.nextInt();
				      
					     switch(ch){
					     case 1:
					    	 Dept="Civil";
					    	 break;
					     case 2:
					    	 Dept="Mech";
					    	 break;
					     case 3:
					    	 Dept="ECE";
					    	 break;
					     case 4:
					    	 Dept="EEE";
					    	 break;
					     case 5:
					    	 Dept="CSE";
					    	 break;
					     case 6:
					    	 Dept="IT";
					    	 break;
					     default:
					    	System.out.println("Enter the correct Dept");
					    	 ch=0;
					     }
				    }
				    catch(InputMismatchException e) {
				 	   System.out.println("Please enter Correct type");
				 	   sc.nextLine();
				    }
				  }
			return Dept ;
		}
		public static String Feesvalidation(int chFe) {
			  String Fees_Status="";
			 while(chFe==0) {
				    try {
				 	    System.out.println("Enter Fees_Status: \n 1.paid \n 2.Not paid");
					          chFe =sc.nextInt();
					       
					         switch(chFe){
					         case 1:
					        	Fees_Status="paid";
					        	break;
					         case 2:
					          	Fees_Status="Not paid";
					        	break;
					         default :
					        	 System.out.println("Enter the Right option"); 
					        	 chFe=0;
					         }
				      }
				    catch(InputMismatchException e) {
				 	   System.out.println("Please enter Correct type");
				 	   sc.nextLine();
				    }
				  }
				  
			return Fees_Status ;
		}
		public static String Quotavalidation(int chQ) {
			String Quota="";
			 while(chQ==0) {
				    try {
				 	  	 System.out.println("Enter Quota :\n1.Govt \n2.Management");
				    	     chQ =sc.nextInt();
				 	       switch(chQ){
				 	         case 1:
				 	        	Quota="Govt";
				 	        	break;
				 	         case 2:
				 	        	Quota="Management";
					        	    break;
					            default :
					        	 System.out.println("Enter the Right option"); 
					        	 chQ=0;
				 	         }
				      }
				    catch(InputMismatchException e) {
				 	   System.out.println("Please enter Correct type");
				 	   sc.nextLine();
				     }
				  }
				  
			return Quota ;
		}
		public static float CGPAvalidation() {
			float CGPA=0;
			 while(CGPA==0) {
				    try {
				 	   System.out.println("Enter CGPA:");
					          CGPA=sc.nextFloat();
				      }
				    catch(InputMismatchException e) {
				 	   System.out.println("Please enter Correct type");
				 	   sc.nextLine();
				     }
				  }
				  
		
			return CGPA ;
		}
		public static String Addressvalidation() {
		String Address="";
		 while(Address=="") {
			    try {
			 	   System.out.println("Enter Address :");
				       Address=sc.nextLine();
			      }
			    catch(InputMismatchException e) {
			 	   System.out.println("Please enter Correct type");
			 	   sc.nextLine();
			    }
			  }
		 return Address;
		 
		}
		public static long phonevalidation(){
			long phone_No=0;
			  while(phone_No==0) {
				    try {
				 	   System.out.println("Enter  phone_No:");
					       phone_No=sc.nextLong();
					       long dum=phone_No;
					       int cnt=0;
					       while(dum>0) {
					    	   cnt++;
					    	   dum=dum/10;
					       }
					       
					       if(cnt!=10) {
					    	   phone_No=0;
					    	  System.out.println("Phone number should be 10 Digits");
					       }
				      }
				    catch(InputMismatchException e) {
				 	   System.out.println("Please enter Correct type");
				 	   sc.nextLine();
				     }
				  }
			 return phone_No;
			 
}
}