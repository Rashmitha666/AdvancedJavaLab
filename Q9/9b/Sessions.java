

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Sessions")
public class Sessions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        HttpSession session = request.getSession();
	        
	        Integer visitCount = (Integer) session.getAttribute("visitCount");
	        
	        if(visitCount == null)
	        {
	        	visitCount = 1;
	        	session.setAttribute("visitCount", visitCount);
	        	
	        	out.println("<h1>Welcome to the webpage!</h1>");
	            out.println("<p>This is your first visit.</p>");
	        }
	        else
	        {
	        	visitCount++;
	            session.setAttribute("visitCount", visitCount);
	
	            out.println("<h1>Welcome back!</h1>");
	            out.println("<p>You have visited this page " + visitCount + " times.</p>");
	        }
    }

}

