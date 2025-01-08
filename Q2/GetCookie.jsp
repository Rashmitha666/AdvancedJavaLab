<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Retrieve Cookie</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
	
		if (cookies != null)
		{
			for(var cookie: cookies)
			{
				out.println("Name: " + cookie.getName() + "<br>");
	            out.println("Value: " + cookie.getValue() + "<br>");
			}
		}
		else
		{
			out.println("<p> No Cookies found </p>");
		}
	
	%>
</body>
</html>