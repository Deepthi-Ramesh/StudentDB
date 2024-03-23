package StudentDB;
import java.sql.*;
public class DBclass {
           //TODO -- FUNCTION FOR ADD A STUDENT - Done
		  //TODO -- FUNCTION FOR UPDATE A STUDENT 
		  //TODO -- FUNCTION FOR DELETE A STUDENT --DOne
		  //TODO -- FUNCTION FOR DISPLAY A STUDENT --Done
	// TODO --- FUNCTION FOR DISPLAY A STUDENT  already existing rollno --rollno
	       //TODO -- DBCONNECTION
	
	public static  String url="jdbc:mysql://localhost:3306/deepu";
	public static String uname="root";
	public static String pass="pass@1234";
   
	
	public static Connection con;
	public static PreparedStatement preparedstatement;
	public static ResultSet resultset;
	
	public static void Connect() throws Exception{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(url, uname, pass);
             System.out.print("connection Established");
			}
		catch(Exception e) {
			System.out.println(e);
			}

	}
	
	public static void Close() throws SQLException{
		if(resultset  != null) {
			resultset.close();
		}
		if(preparedstatement!=null) {
			preparedstatement.close();
		}
		if(con !=null) {
			con.close();
		}
	}

public static void main(String[] args) throws Exception  {
	        Connect();
//	        boolean flag =FindRollNo(3);
//	        System.out.println(flag);
	}
    public static int AddStudent(Student student) throws Exception  {
    	Connect();
    	String query = "INSERT INTO STUDENTDB VALUES(?,?,?,?,?,?,?,?,?)";
    	preparedstatement=con.prepareStatement(query);
    	preparedstatement.setInt(1,student.Roll_No);
    	preparedstatement.setString(2, student.Student_Name);
    	preparedstatement.setInt(3, student.Year);
    	preparedstatement.setString(4, student.Dept);
    	preparedstatement.setString(5, student.Fees_Status);
    	preparedstatement.setString(6, student.Quota);
    	preparedstatement.setFloat(7, student.CGPA);
    	preparedstatement.setString(8, student.Address);
    	preparedstatement.setLong(9, student.phone_No);
       	int count =preparedstatement.executeUpdate();
       
    	Close();
    	return count;
    	
    }
    public static int UpdateStudentStr(String parameter,String str ,int rollno) throws Exception  {
    	Connect();
    	String query = "UPDATE STUDENTDB SET " + parameter + "=? WHERE ROLL_NO=? ";
    	preparedstatement=con.prepareStatement(query);
        preparedstatement.setString(1,str);
        preparedstatement.setInt(2,rollno);
    	int count=preparedstatement.executeUpdate();
        Close();
    	return count;
}
    public static int UpdateStudentlong(String parameter,long value ,int rollno) throws Exception  {
    	Connect();
    	String query = "UPDATE STUDENTDB SET " + parameter + "=? WHERE ROLL_NO=? ";
    	preparedstatement=con.prepareStatement(query);
    	if(parameter=="year") {
    		preparedstatement.setInt(1,(int)value);
    	}
    	if(parameter=="CGPA") {
    		preparedstatement.setFloat(1,(float)value);
    	}
    	if(parameter=="phone_No") {
    		preparedstatement.setLong(1,value);
    	}
    
    	preparedstatement.setInt(2,rollno);
   
       	int count=preparedstatement.executeUpdate();
       
        Close();
    	return count;
    	
}
    public static int DeleteStudent(int rollno)throws Exception {
    	Connect();
        int count=0;
        	if(FindRollNo(rollno)) {
        		String query = "DELETE FROM STUDENTDB WHERE ROLL_NO = ?";
            	preparedstatement=con.prepareStatement(query);
            	preparedstatement.setInt(1,rollno);
                count =preparedstatement.executeUpdate();
            }
    	 Close();
    	return count;
    }
    
    public static String DisplayStudent(int rollno)throws Exception {
    	Connect();
    	 String details ="";
        	if(FindRollNo(rollno)) {
        		String query = "SELECT * FROM STUDENTDB WHERE ROLL_NO = ?";
            	preparedstatement=con.prepareStatement(query);
            	preparedstatement.setInt(1,rollno);
        	    ResultSet rs=preparedstatement.executeQuery();
             
                while (rs.next()) {
                	details = "Name :"+ rs.getString(2)+"\nYear :"+rs.getInt(3)+"\nDept :"+rs.getString(4)+"\nFees_Status :"+rs.getString(5)+"\nQuota : "+rs.getString(6) + "\nCGPA :"+rs.getFloat(7)+"\nAddress :"+rs.getString(8)+"\nPhone No :"+rs.getLong(9);
                }       
               }
        	else {
        		 details ="Roll no not found";
        	}
    	 Close();
    	return details;
    }
public static boolean FindRollNo(int rollno)throws Exception {
	Connect();
    String qu="SELECT ROLL_NO FROM STUDENTDB";
    Statement st = con.createStatement();
    ResultSet rs=st.executeQuery(qu);
    int no;boolean flag=false;
    while(rs.next()) {
    	no=rs.getInt("roll_no");
    	System.out.println(no);
    	System.out.println(rollno);
    	if(no==rollno) {
    		flag=true;
    		break;
    }
    	else {
    		flag=false;
    	}
    }
	  Close();
	return flag;
}
}