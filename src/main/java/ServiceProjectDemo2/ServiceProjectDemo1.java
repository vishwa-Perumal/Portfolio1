package ServiceProjectDemo2;

import java.sql.SQLException;

import Repository.DAOUser;

public class ServiceProjectDemo1 {
	DAOUser daouser = new DAOUser();
	
	public String getuserrole(String user_name,String user_password) throws SQLException {
		try {
			return  daouser.getuserrole(user_name, user_password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	
	public void createuser(String name, String password) {
		// TODO Auto-generated method stub
		System.out.println(name+" from service class1");
		daouser.createguestuser(name, password);
		System.out.println(name+" from service class2");
	}

}
