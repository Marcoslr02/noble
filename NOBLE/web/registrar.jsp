<%-- 
    Document   : registrar
    Created on : 30/04/2017, 03:34:14 PM
    Author     : Héctor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="JavaScript" type="text/javascript" src="JS/validar.js"></script>
        <title>Registrarse</title>
        <link rel="stylesheet" href="CSS/Formi.css">
    </head>
    <body>
 
        <form action="Registrar" method="POST" class="formi" autocomplete="off" onsubmit="return validar();">
                <h2 class="titulo"> Crea una cuenta </h2>
                <div name="contenedor" id="contenedor" class="contenedor">
                    <input type="text" name="nombre" placeholder="Nombre" class="input-100" required  maxlength="45"
                           ondrop="return false" ondrag="return false" onpaste="return false" onkeypress=" return validarlet(event)" >
                    <input type="text" name="appat" placeholder="Apellido Paterno" class="input-48" required maxlength="45"
                           ondrop="return false" ondrag="return false" onpaste="return false" onkeypress=" return validarlet(event)">
                    <input type="text" name="apmat" placeholder="Apellido Materno" class="input-48" required maxlength="45"
                           ondrop="return false" ondrag="return false" onpaste="return false" onkeypress=" return validarlet(event)">
                    <input type="email" name="correo" placeholder="Correo" class="input-100"required maxlength="45"
                           ondrop="return false" ondrag="return false" onpaste="return false" onkeypress=" return validarcorreo(event)">
                    
                    <select name="estado" id="pais" required class="input-48">
                                        <option>País</option>
                                        <option value="Argentina">Argentina</option>
                                        <option value="Bolivia">Bolivia</option>
                                        <option value="Brasil">Brasil</option>
                                        <option value="Chile">Chile</option>
                                        <option value="Colombia">Colombia</option>
                                        <option value="Ecuador">Ecuador</option>
                                        <option value="Guyana">Guyana</option>
                                        <option value="Paraguay">Paraguay</option>
                                        <option value="Peru">Peru</option>
                                        <option value="Surinam">Surinam</option>
                                        <option value="Uruguay">Uruguay</option>
                                        <option value="Venezuela">Venezuela</option>
                                        <option value="Belice">Belice</option>
                                        <option value="Costa Rica">Costa Rica</option>
                                        <option value="El Salvador">El Salvador</option>
                                        <option value="Guatemala">Guatemala</option>
                                        <option value="Honduras">Honduras</option>
                                        <option value="Nicaragua">Nicaragua</option>
                                        <option value="Panamá">Panamá</option>
                                        <option value="Canadá">Canadá</option>
                                        <option value="EE.UU">EE.UU</option>
                                        <option value="México">México</option>
                                        <option value="Otro">Otro</option>
                                    </select>
                    
                                <select name="estado" id="estado" class="input-48">
                                    <option value="" selected> Estado </option>
                                        <option value="AGUASCALIENTES">AGUASCALIENTES</option>
                                        <option value="BAJA CALIFORNIA">BAJA CALIFORNIA</option>
                                        <option value="BAJA CALIFORNIA SUR">BAJA CALIFORNIA SUR</option>
                                        <option value="CAMPECHE">CAMPECHE</option>
                                        <option value="CHIAPAS">CHIAPAS</option>
                                        <option value="CHIHUAHUA">CHIHUAHUA</option>
                                        <option value="COAHUILA">COAHUILA</option>
                                        <option value="COLIMA">COLIMA</option>
                                        <option value="CDMX">CDMX</option>
                                        <option value="DURANGO">DURANGO</option>
                                        <option value="GUANAJUATO">GUANAJUATO</option>
                                        <option value="GUERRERO">GUERRERO</option>
                                        <option value="HIDALGO">HIDALGO</option>
                                        <option value="JALISCO">JALISCO</option>
                                        <option value="MEXICO">MEXICO</option>
                                        <option value="MORELOS">MORELOS</option>
                                        <option value="MICHOACAN">MICHOACAN</option>
                                        <option value="NAYARIT">NAYARIT</option>
                                        <option value="NUEVO LEON">NUEVO LEON</option>
                                        <option value="OAXACA">OAXACA</option>
                                        <option value="PUEBLA">PUEBLA</option>
                                        <option value="QUERETARO">QUERETARO</option>
                                        <option value="QUINTANA ROO">QUINTANA ROO</option>
                                        <option value="SAN LUIS POTOSI">SAN LUIS POTOSI</option>
                                        <option value="SINALOA">SINALOA</option>
                                        <option value="SONORA">SONORA</option>
                                        <option value="TABASCO">TABASCO</option>
                                        <option value="TAMAULIPAS">TAMAULIPAS</option>
                                        <option value="TLAXCALA">TLAXCALA</option>
                                        <option value="VERACRUZ">VERACRUZ</option>
                                        <option value="YUCATAN">YUCATAN</option>
                                        <option value="ZACATECAS">ZACATECAS</option>
                                        <option value="EXTRANJERO">EXTRANJERO</option>
                                    </select>
                    <select name="genero" id="genero" required class="input-48">
                                    <option>Genero</option>
                                    <option value="H">Hombre</option>
                                    <option value="M">Mujer</option>
                     </select>
                    <input type="date"
                           name="nac" 
                                           max="2017-04-17"
                                           min="1900-01-01"
                                           required class="input-48">
                    <input type="text" name="usuario" placeholder="Usuario" class="input-48" required maxlength="45"
                           ondrop="return false" ondrag="return false" onpaste="return false" onkeypress=" return validarletynum(event)">
                    <input type="password" name="password" placeholder="Contraseña" class="input-48" required maxlength="45"
                           ondrop="return false" ondrag="return false" onpaste="return false" onkeypress=" return validarletynum(event)">
                    <input type="submit" value="Registrar" class="btnenviar">
                    <p class="links">¿Ya tienes una cuenta? <a href="login.jsp">Ingresa aquí.</a></p>
                </div>
            </form>
    </body>
</html>
