package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUser {
	
	public String getuserrole(String user_name,String user_password) throws SQLException, ClassNotFoundException {
		 String role = null;
		 try {
		        Class.forName("org.postgresql.Driver");
		    	Connection connection = DataBase.getConnection();
				PreparedStatement ps =connection.prepareStatement("SELECT urole FROM table4 where uname=? and upassword=?");
				ps.setString(1, user_name);
				ps.setString(2, user_password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					 role = rs.getString("urole");
					
				}
				return role;

		    } catch (ClassNotFoundException e) {
		        throw new RuntimeException("PostgreSQL Driver not found", e);
		    }
	
		
		
	}

}
