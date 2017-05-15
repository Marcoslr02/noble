<%-- 
    Document   : SesionJuego
    Created on : 15/05/2017, 03:14:57 PM
    Author     : Héctor
--%>
<% if(session.getAttribute("usuario") == null){
   response.sendRedirect("login.jsp");
}
else{
    response.sendRedirect("prueba/index.jsp");
}
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
