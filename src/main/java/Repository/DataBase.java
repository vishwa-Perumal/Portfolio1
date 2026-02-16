package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	public static Connection getConnection() throws SQLException {
	 try {
	Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/database1","postgres","root");
	return connection;
	 }catch (Exception e)
	 {
		 System.out.println(e);
	 }	
	 return null;
	}		

}
