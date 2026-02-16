package ServiceProjectDemo2;

import java.sql.SQLException;

import Repository.DAOUser;

public class ServiceProjectDemo1 {
	DAOUser daouser = new DAOUser();
	
	public String getuserrole(String user_name,String user_password) throws SQLException {
		try {
			return  daouser.getuserrole(user_name, user_password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
