

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/displayCookies")
public class displayCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Cookie cookie1 = new Cookie("Cookie1", "Value1");
        Cookie cookie2 = new Cookie("Cookie2", "Value2");
        Cookie cookie3 = new Cookie("Cookie3", "Value3");
        Cookie cookie4 = new Cookie("Cookie4", "Value4");
        
        cookie1.setMaxAge(60); 
        cookie2.setMaxAge(60);
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
        
        Cookie[] cookies = request.getCookies();

        out.println("<h2>Cookies Status</h2>");

        if (cookies != null) 
        {
            for (Cookie cookie : cookies) 
            {
                out.println("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
            }
        } 
        
        else 
        {
            out.println("<p>No cookies found. Some cookies might have expired.</p>");
        }

        out.println("<p>Refresh the page to see the effect of cookie expiration.</p>");
	}

}
