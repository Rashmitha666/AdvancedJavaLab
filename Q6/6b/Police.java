

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/Police")
public class Police extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Police() 
    {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String url = "jdbc:mysql://localhost:3306/rashu";
		String user = "root";
		String pass ="";
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String input = request.getParameter("input");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, pass);
			
            String query = "SELECT * FROM police_station WHERE area = ? OR phone_number = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, input);
            ps.setString(2, input);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
            	String area = rs.getString("area");
                String phoneNumber = rs.getString("phone_number");

                out.println("<p>Area: " + area + "</p>");
                out.println("<p>Phone Number: " + phoneNumber + "</p>");
            }


		}
		catch (Exception e) 
		{
            e.printStackTrace();
        }
	}

}
