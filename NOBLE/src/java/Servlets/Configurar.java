/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Consultas;
import Controlador.Datos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class Configurar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession objse = request.getSession(false);  
            if(objse.getAttribute("usuario") == null){
                response.sendRedirect("login.jsp");
            }
            else{
            out.println("<script language=\"JavaScript\" type=\"text/javascript\" src=\"JS/validar.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"CSS/Formi.css\">");
            
            String usuario = (String)objse.getAttribute("usuario");
            Datos e = Consultas.getUsuarioByUsuario(usuario);
            
            out.println("<form action='Configurar2' method='post' class='formi' autocomplete='off' onsubmit='return validar();'>");
            out.println("<h2 class=\"titulo\"> Edita tus datos "+e.getUsuario()+".</h2>");
            out.println("<div name=\"contenedor\" id=\"contenedor\" class=\"contenedor\">");
             out.println("<input type=\"text\" name=\"id2\" placeholder=\"ID\" class=\"input-100\" required  maxlength=\"45\"\n" +
"                           ondrop=\"return false\" ondrag=\"return false\" onpaste=\"return false\" onkeypress=\" return validarnum(event)\" readonly value="+e.getId()+">");
            out.println("<input type=\"text\" name=\"nombre2\" placeholder=\"Nombre\" class=\"input-100\" required  maxlength=\"45\"\n" +
"                           ondrop=\"return false\" ondrag=\"return false\" onpaste=\"return false\" onkeypress=\" return validarlet(event)\" value="+e.getNombre()+">");
            out.println("<input type=\"email\" name=\"correo2\" placeholder=\"Correo\" class=\"input-100\"required maxlength=\"45\"\n" +
"                           ondrop=\"return false\" ondrag=\"return false\" onpaste=\"return false\" onkeypress=\" return validarcorreo(event)\" value="+e.getCorreo()+ ">");
            out.println("<input type=\"text\" name=\"usuario2\" placeholder=\"Usuario\" class=\"input-100\" required  maxlength=\"45\"\n" +
"                           ondrop=\"return false\" ondrag=\"return false\" onpaste=\"return false\" onkeypress=\" return validarlet(event)\" value="+e.getUsuario()+">");
            out.println("<input type=\"password\" name=\"contrasena2\" placeholder=\"Contraseña\" class=\"input-100\" required  maxlength=\"45\"\n" +
"                           ondrop=\"return false\" ondrag=\"return false\" onpaste=\"return false\" onkeypress=\" return validarcorreo(event)\" value="+e.getContrasena()+">");
            out.println("<input type=\"submit\" value=\"Actualizar\" class=\"btnenviar\">");
            out.println("</div>");
            out.println("</form>");
            out.close();
        }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
