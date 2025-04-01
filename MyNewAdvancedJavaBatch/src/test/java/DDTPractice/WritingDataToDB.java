package DDTPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WritingDataToDB {
	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninja_E18","root","AnuVasu0617@");
		Statement smt = conn.createStatement();
		int result = smt.executeUpdate("insert into Ninja_CRM_Details values('safari','http://49.249.28.218:8098/dashboard','jayu','1234qer')");
		int result1 = smt.executeUpdate("insert into Ninja_CRM_Details values('mozilla','http://49.249.28.218:8098/dashboard','jayu1','1234abc')");

		System.out.println(result);
		if(result!=0 || result1<=0 && result1>0)
		{
			System.out.println("Data Stored Successfully");
		}
		else
		{
			System.out.println("not updated");
		}
		conn.close();
	}

}
