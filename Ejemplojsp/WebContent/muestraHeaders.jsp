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
response.setContentType("text/html");
java.util.Enumeration e = request.getHeaderNames();
out.println("<style>");
out.println(".gris{");
out.println("  background-color : grey;");
out.println("}");
out.println("</style>");
out.println("<table>");
while (e.hasMoreElements()) {
    String name = (String)e.nextElement();
    String value = request.getHeader(name);
    out.println("<tr>");
    out.println("<td class='gris'>"+name+"</td>");
    out.println("<td>"+value+"</td>");
    out.println("</tr>");
}
out.println("</table>");
out.println("</body>");
out.println("</html>");
%>
</body>
</html>