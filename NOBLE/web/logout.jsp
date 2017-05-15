<%-- 
    Document   : logout
    Created on : 15/05/2017, 02:57:36 PM
    Author     : Héctor
--%>
<%
HttpSession sesion = request.getSession();
sesion.setAttribute("usuario","");
sesion.invalidate();
response.sendRedirect("noble.jsp");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
