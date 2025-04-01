package Generic_Utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import com.mysql.cj.jdbc.Driver

public class DatabaseUtility {
	Connection conn;
	public void getDBConection(String url,String uname,String password)
	{
		try {
			Driver driver=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url, uname, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("connection not Established");
		}
	}
	public void closeDBConnection()
	{
		try {
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
public ResultSet executeSelectQuery(String query)
{
	ResultSet result=null;
	try {
	Statement stmt = conn.createStatement();
	
		result=stmt.executeQuery(query);
	} catch (Exception e) {
		// TODO Auto-generated catch block
	}
	return result;
}
public int executeNonSelectQuery(String query)
{
	int result=0;
	try {
	Statement stmt = conn.createStatement();
	
		result=stmt.executeUpdate(query);
	} catch (Exception e) {
		// TODO Auto-generated catch block
	}
	return result;

}
}
