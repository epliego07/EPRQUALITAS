<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <% 
     String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
  %>
  <h1>Dias Laborables</h1>
  <ul>
       <%
         for(String dia:dias){
        	 out.print("<li>");
        	 out.print(dia);
        	 out.print("</li>");
         }
       %>
  </ul>
</body>
</html>