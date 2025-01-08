<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<%
			Cookie cookie1 = new Cookie("user1", "value1");
	        Cookie cookie2 = new Cookie("user2", "value2");
			Cookie cookie3 = new Cookie("user3", "value3");
			
			cookie1.setMaxAge(60);
			cookie2.setMaxAge(60);
			cookie3.setMaxAge(60);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			
	%>

			<h2>Cookies have been set!</h2>
		    <p>Go to <a href="GetCookie.jsp">GetCookies.jsp</a> to retrieve and display them.</p>
			
</body>
</html>