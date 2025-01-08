<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Price</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
    	int age = Integer.parseInt(request.getParameter("age"));
    	
    	int ticketPrice=0;
    	
    	if (age > 62) 
    	{
            ticketPrice = 50;
        } 
    	else if (age < 10) 
    	{
            ticketPrice = 30;
        } 
    	else 
    	{
            ticketPrice = 80;
        }
    	
    	if(ticketPrice >0)
    	{
    		out.println("<h2>Ticket Price</h2><br>");
    		out.println("Hello<strong>" + name + "</strong>!<br>");
    		out.println("your age is<strong>" + age + "</strong>!<br>");
    		out.println("Ticket Price is<strong>" + ticketPrice + "</strong>!");
    		
    	}
	%>
</body>
</html>