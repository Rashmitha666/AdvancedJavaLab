

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
		
		//additionally you can print name and email if preferred
	        String dob = request.getParameter("dob");
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate birthDate = LocalDate.parse(dob, formatter);
	        LocalDate currentDate = LocalDate.now();
	
	        int age = Period.between(birthDate, currentDate).getYears();
	        
	        
	        if (age >= 18) 
	        {
	            out.println("<p>Status: <strong>Eligible to vote</strong></p>");
	        } 
	        else 
	        {
	            out.println("<p>Status: <strong>Not eligible to vote</strong></p>");
	        }
		
	}

}
