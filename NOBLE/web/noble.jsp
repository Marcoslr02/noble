<%-- 
    Document   : noble
    Created on : 27/04/2017, 05:48:53 PM
    Author     : CECyT9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noble</title>
        <link rel="stylesheet" href="CSS/NOBLE.css">
    </head>
    <body>
        
        
        <table align="center" style="width: 900px">
            <tr>
                <th></th>
                <th  class="titulo" colspan="2">
                    <h1>¡Bienvenido a Noble!</h1>
                </th>
                
            </tr>
            <tr>
                <th></th>
                <th  class="linea" colspan="2"></th>
            </tr>
            <tr>
                <th class="video" colspan="4">
                    <br>
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/DEeAN471boQ" frameborder="0" allowfullscreen></iframe></iframe>
                </th>
            </tr>
            <tr>
                <th  class="info" colspan="4">
                    <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                </th>
            </tr>
            
        </table>
  
        <table align="center" style="width: 900px;">
            <tr>
                <td>
                    <input type="button" class="boton1 boton"  onClick="location.href = 'registrar.jsp' " value="Registrarse">
                </td>
                <td>
                    <input type="button" class="boton1 boton" onClick="location.href = 'login.jsp' " value="Iniciar Sesion">
                </td>
            </tr>
        </table>
    </body>
</html>
