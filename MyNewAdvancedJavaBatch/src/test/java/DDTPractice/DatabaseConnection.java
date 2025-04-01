package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection 
{
	public static void main(String[] args) throws SQLException {
		
	com.mysql.cj.jdbc.Driver driveref=new com.mysql.cj.jdbc.Driver();
DriverManager.registerDriver(driveref);
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninja_E18","root","AnuVasu0617@");
if(conn.isClosed()) {
	System.out.println("Not Connected to database");
}
else
	
{
	System.out.println("Successfully connected to database");
}
Statement stmt=conn.createStatement();
ResultSet  result = stmt.executeQuery("Select *from Ninja_CRM_Details");
while(result.next()) {
	String browser=result.getString(1);
	String url=result.getString(2);
	String uname=result.getString(3);
	String pwd=result.getString(4);
	System.out.println("======================");
System.out.println(browser);
System.out.println(url);
System.out.println(uname);
System.out.println(pwd);



}
conn.close();
}


}
 
 

 
	
	 

