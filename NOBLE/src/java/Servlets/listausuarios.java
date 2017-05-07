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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Héctor
 */
public class listausuarios extends HttpServlet {

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
            out.println("<link rel=\"stylesheet\" href=\"CSS/TABLES.css\">");
            out.println("<br><h1> ¡Hola Administrador! </h1>");
            
            List<Datos> lista = Consultas.getAllEmpleados();
            
            out.println("<table align='center'>");
            out.println("<tr>"
                    + "<th> ID </th>"
                    + "<th> Nombre </th>"
                    + "<th> Correo </th>"
                    + "<th> Usuario </th>"
                    + "<th> Contraseña </th>"
                    + "<th>  </th>"
                    + "<th>  </th>"
                    + "</tr>");
            for(Datos e:lista){
                out.println("<tr>"
                        + "<td>"+e.getId()+"</td>"
                        + "<td>"+e.getNombre()+"</td>"
                        + "<td>"+e.getCorreo()+"</td>"
                        + "<td>"+e.getUsuario()+"</td>"
                        + "<td>"+e.getContrasena()+"</td>" 
                        + "<td><a href='EditarServlet?id="+e.getId()+"'>Editar</a></td>"
                        + "<td><a href='Borrar?id1="+e.getId()+" '>Borrar</a></td>"        
                        + "</tr>");
            }
            out.println("</table>");
            out.close();
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
