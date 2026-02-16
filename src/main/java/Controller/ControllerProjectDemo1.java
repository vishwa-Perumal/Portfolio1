package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ServiceProjectDemo2.ServiceProjectDemo1;

public class ControllerProjectDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServiceProjectDemo1 service = new ServiceProjectDemo1();
	
		String username=req.getParameter("username");
		String userpassword=req.getParameter("password");
		String role = null;
		
		try {
			role=service.getuserrole(username,userpassword);
			System.out.println(role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("name",username);
		session.setAttribute("password",userpassword);
		session.setAttribute("role",role);
		
		if(role.equals("admin")) {
			
			resp.sendRedirect("admin");

		
//		RequestDispatcher rd = req.getRequestDispatcher("/admin");
//		rd.forward(req, resp);
		}
		if(role.equals("employe")) {
			resp.sendRedirect("employe");
			
//			RequestDispatcher rd = req.getRequestDispatcher("/employe");
//			rd.forward(req, resp);
			}
		if(role.equals("guest")) {
			
			resp.sendRedirect("guest");
			
//			RequestDispatcher rd = req.getRequestDispatcher("/guest");
//			rd.forward(req, resp);
			}

	}
	
	

}
