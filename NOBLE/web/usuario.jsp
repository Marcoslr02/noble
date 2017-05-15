<%-- 
    Document   : usuario
    Created on : 7/05/2017, 04:33:44 PM
    Author     : Héctor
--%>

<% if(session.getAttribute("usuario") == null){
   response.sendRedirect("login.jsp");
}%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/NOBLE.css">
        <title>JSP Page</title>
    </head>
    <body>
     
        <table class="botones1" align="center" style="width: 900px">
            <tr>
                <td> <br><a href="Configurar"><img src="IMAGES/config.png" width="50px" height="50px"></a></td>
                <td align="right"><br> <a href="logout.jsp"><img src="IMAGES/logout.png" width="40px" height="40px" ></a></td>
             </tr>
            </table>
         <table class="botones2" align="center" style="width: 900px">
             
            <tr>
                <th></th>
                <th  class="titulo" colspan="2">
                    <h1>¡Bienvenido!</h1>
                </th>
                
            </tr>
            <tr>
                <th></th>
                <th  class="linea" colspan="2"></th>
            </tr>

            <tr style="height: 400px">
                <td colspan="2" >
                    <iframe  src="texto/index.html" name="frame" id="frame" width="100%" height="90%"></iframe>
                </td>
            </tr>
            
        </table>
           
        <table class="botones" align="center" style="width: 900px;">
            <tr>
                <td colspan="2">
                    <input type="button" class="boton1 boton" onClick="location.href = 'SesionJuego.jsp' " value="Jugar capaña">
                </td>
            </tr>
            
        </table
     
    </body>
</html>
