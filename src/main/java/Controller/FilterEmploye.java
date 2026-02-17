package Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterEmploye implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest reqs, ServletResponse resps, FilterChain chain)
			throws IOException, ServletException {
		 
		HttpServletRequest req = (HttpServletRequest) reqs;
		HttpServletResponse resp= (HttpServletResponse) resps;
		
		HttpSession session=req.getSession(false);
		String role =(String) session.getAttribute("role");
		if("employe".equals(role)) {
			System.out.println("this is from employe filter");
			chain.doFilter(reqs, resps);
		}
		else {
			 resp.sendRedirect("index.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
