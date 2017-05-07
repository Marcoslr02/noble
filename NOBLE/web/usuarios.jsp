<%-- 
    Document   : usuarios
    Created on : 3/05/2017, 08:24:33 PM
    Author     : CECyT9
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>¡Hola administrador!</h1>
        <%
            Connection co  = DriverManager.getConnection("jdbc:mysql://localhost:3306/noble","root","n0m3l0");
            Statement st = co.createStatement();
            String query ="select p.idpersona, p.nombre, p.correo, u.nomusuario, u.contrasenia"
                    + " from dpersona p inner join musuario u on p.idpersona=u.idpersona";
            ResultSet resultset = 
                st.executeQuery(query) ; 
        %>
        <TABLE align="center">
            <TR>
                <TH>Usuario</TH>
                <TH>Comentario</TH>
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD class="usuario" width="30%"> <%= resultset.getString(1) %></TD>
                <TD> <%= resultset.getString(2) %></TD>
            </TR>
            <% } %>
        </TABLE>
    </body>
</html>
