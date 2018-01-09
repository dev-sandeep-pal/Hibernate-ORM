

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/login")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String n = request.getParameter("name");
   		String p = request.getParameter("pwd");
   		
   		Configuration cfg = new Configuration();
   		cfg.configure("login.cfg.xml");
   		SessionFactory sf = cfg.buildSessionFactory();
   		Session s = sf.openSession();
   		
   		LOgin l = (LOgin)s.load(LOgin.class,1);
   		
   		if(n.equalsIgnoreCase(l.getName()) && p.equals(l.getPass())){
   			RequestDispatcher rs = request.getRequestDispatcher("success.jsp");
   			rs.forward(request, response);
   		}else{
   			response.sendRedirect("login.html");
   		}
   			
   	}

}
