package DDTPractice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpadateDbms {
	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninja_E18","root","AnuVasu0617@");
		Statement smt = conn.createStatement();
		int result = smt.executeUpdate("update Ninja_CRM_Details set uname='admin' where Browser='safari'");
		
		System.out.println(result);
		if(result!=0)
		{
			System.out.println("Data updated  Successfully......");
		}
		else
		{
			System.out.println("Data not updated......");
		}
		conn.close();
	}

}

