package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceProjectDemo2.ServiceProjectDemo1;

public class ControllerSignUp1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServiceProjectDemo1 service = new ServiceProjectDemo1();
		
		String name=req.getParameter("uname");
		String password=req.getParameter("upassword");
		System.out.println(name +" "+password);
		try {
		service.createuser(name, password);
		
		System.out.println("user created successfully");
		}catch(Exception e) {
			System.out.println("enter valid user name and password");
		}
		
	}
	
	

}
