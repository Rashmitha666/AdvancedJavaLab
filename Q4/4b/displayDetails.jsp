<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information</title>
</head>
<body>
	<%@ page import = "java.sql.*" %>
		<h1>Student Details</h1>
		<table border = "1">
			<thead>
				<tr>
					<th>USN</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<%
					String url = "jdbc:mysql://localhost:3306/rashu";
					String user = "root";
					String pass = "";
					
					Connection conn = null;
					Statement stmt = null;
					PreparedStatement ps = null;
					

					Class.forName("com.mysql.cj.jdbc.Driver");
					
					conn = DriverManager.getConnection(url, user, pass);
					stmt = conn.createStatement();
					
					int usn = Integer.parseInt(request.getParameter("usn"));
					
					String sqlQuery = "Select * from Student where usn = ?";
					ps = conn.prepareStatement(sqlQuery);
					ps.setInt(1,usn);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next())
					{
						int Usn = rs.getInt("usn");
						String Name = rs.getString("name");
						
						out.println("<tr><td>" + Usn + "</td><td>" + Name + "</td></tr>");
					}
					else
					{
						out.println("No data found");
					}
					
				%>
			</tbody>
		</table>
</body>
</html>
