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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Héctor
 */
public class Actualizar2 extends HttpServlet {

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
         response.setContentType("text/html;charset=UTF-8");
         HttpSession objse = request.getSession(false);  
        String usuariolol = (String)objse.getAttribute("usuario");
        if(usuariolol !="admin"){
            response.sendRedirect("login.jsp");
        }else{
        try (PrintWriter out = response.getWriter()) {
            int id;
            Datos e = new Datos();
            Consultas co = new Consultas();
            co.getConnection();
            String  nombre, correo, usuario, contrasena;
            id = Integer.parseInt(request.getParameter("id2"));
            e = Consultas.getUsuarioById(id);
            nombre = request.getParameter("nombre2");
            correo = request.getParameter("correo2");
            usuario = request.getParameter("usuario2");
            contrasena= request.getParameter("contrasena2");
            try {
                if(co.validarUsuario(usuario) && e.getUsuario()==usuario){
                    out.println("<h1>ya existe el usuario</h1>");
                }else{
                    if(co.validarCorreo(correo) && e.getCorreo()==correo){
                         out.println("<h1>ya existe el correo</h1>");
                         System.out.println(e.getCorreo());
                         System.out.println(correo);
                    }else{
                        
                        e.setId(id);
                        e.setNombre(nombre);
                        e.setCorreo(correo);
                        e.setUsuario(usuario);
                        e.setContrasena(contrasena);
                        int estado = Consultas.Actualizar(e);
                        if (estado>0) {
                            response.sendRedirect("listausuarios");
                        }
                        else{
                            out.println("<h1> No se pudo actualizar. </h1>");
                        }
                    }
                }
            } catch (SQLException ex) {
                 Logger.getLogger(Actualizar2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
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
