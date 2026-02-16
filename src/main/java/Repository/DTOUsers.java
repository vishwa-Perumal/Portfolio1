package Repository;

public class DTOUsers {
	
	private String user_name;
	private String user_password;
	private String user_role;
	
	//constructor
	public DTOUsers (String user_name,String user_password,String user_role ){
		this.user_name=user_name;
		this.user_password=user_password;
		this.user_role=user_role;
	}
	
	//constructor
	public DTOUsers (String user_name,String user_password ){
		this.user_name=user_name;
		this.user_password=user_password;
	}
	
	//getter
	public String getusersname() {
		return user_name;
	}
	public String getpassword() {
		return user_password;
	}
	public String getuserrole() {
		return user_role;
	}
	
	
	//setter
	public void setusername(String user_name) {
		this.user_name=user_name;
	}
	public void setuserpassword(String user_password) {
		this.user_password=user_password;
	}
	public void setuserrole(String user_role) {
		this.user_role=user_role;
	}
	
	

}
