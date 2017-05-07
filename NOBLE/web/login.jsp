<%-- 
    Document   : login
    Created on : 30/04/2017, 04:23:16 PM
    Author     : Héctor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="JavaScript" type="text/javascript" src="JS/validar.js"></script>
        <link rel="stylesheet" href="CSS/Formi.css">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Ingresar" method="POST" autocomplete="off" id="form1" class="formi">
                <h2 class="titulo">Ingresa tus datos </h2>
                <div class="contenedor">
                    <input type="text" name="usuario" id="usuario"  placeholder="Usuario" class="input-100" maxlength="45"
                           onpaste="return false" ondrag="return false" ondrop="return false" required onkeypress=" return validarletynum(event)">
                    <input type="password" name="password" id="password"  placeholder="Contraseña" class="input-100" maxlength="45"
                           onpaste="return false" ondrag="return false" ondrop="return false"  required onkeypress=" return validarletynum(event)">
                    <input type="submit" value="Entrar" id="btniniciar" class="btnenviar">
                    <p class="links">¿No tienes una cuenta? <a href="registrar.jsp">Registrate aquí.</a></p>
                </div>
            </form>
    </body>
</html>
