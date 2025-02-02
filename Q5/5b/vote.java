

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public vote() 
    {
        super();
     
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate birthDate = LocalDate.parse(dob, formatter);
	        LocalDate currentDate = LocalDate.now();
	
	        int age = Period.between(birthDate, currentDate).getYears();
	        
	  		      
	        if (age >= 18) 
	        {
		    	out.println("<p>Name: <strong>" + firstName + " " + lastName + "</strong></p>");
		    	out.println("<p>Email: <strong>" + email + "</strong></p>");
		    	out.println("<p>Status: <strong>Eligible to vote</strong></p>");
	        } 
	        else 
	        {
	            out.println("<p>Status: <strong>Not eligible to vote</strong></p>");
	        }
		
	}

}
