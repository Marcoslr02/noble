/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.Consultas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Héctor
 */
public class Registrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String nombre = request.getParameter("nombre");
        String appat = request.getParameter("appat");
        String apmat = request.getParameter("apmat");
        String correo = request.getParameter("correo");
        String pais = request.getParameter("pais");
        String estado = request.getParameter("estado");
        String genero = request.getParameter("genero");
        String nac = request.getParameter("nac");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
Consultas co = new Consultas();
        /*
            if(co.validarCorreo(correo)){
                respuesta.setAttribute("error", "Esta direccion de correo ya fue registrada");
                System.out.println("cuenta anteriormente registrada");
            } else {
                //Legado a este punto significa que todo esta correcto, por lo tanto ingreso a la DB
                System.out.println("continua");
            }
        */
        co.getConnection();
        try {
            if(co.validarCorreo(correo)){
                response.sendRedirect("registrar.jsp");
                System.out.println("El correo ya esta registrado");
            }else{
                if(co.validarUsuario(usuario)){
                    response.sendRedirect("registrar.jsp");
                    System.out.println("El usuario ya esta registrado");
                    
                }else{
                    if(co.IngresarPartida()){
                        if(co.InsertarPersona(correo, nombre, appat, apmat, nac, genero, pais, estado)){
                            if(co.InsertaUsuario(usuario, password)){
                                response.sendRedirect("login.jsp");
                            }else{
                                response.sendRedirect("registrar.jsp");
                                System.out.println("ocurrio un problema al registrar al usuario");
                            }
                        }else{
                            response.sendRedirect("registrar.jsp");
                            System.out.println("ocurrio un problema al registrar a la persona");
                        }
                    }
                    else{
                        response.sendRedirect("registrar.jsp");
                        System.out.println("ocurrio un problema al crear la partida");
                    }
                }
                
            }
        }catch(Exception e) {
            System.out.println("salio del try");
        }
        System.out.println("si no menciona nada del tri es que paso olimpicamente de el (T_T)");
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
