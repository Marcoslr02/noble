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
            System.out.println("entro en el try");
            if(co.sololetras(nombre)){
                System.out.println("nombre correcto");
                if(co.sololetras(appat)){
                    System.out.println("paterno correcto");
                    if(co.sololetras(apmat)){
                        System.out.println("materno correcto");
                        if(co.correo(correo)){
                            System.out.println("correo correcto");
                            if(co.sololetrasNum(usuario, password)){
                                System.out.println("usuario y contraseña correcto");
                                try{
                                    if(co.validarCorreo(correo)){
                                        System.out.println("correo con registro previo");
                                        response.sendRedirect("registrar.jsp");
                                    }else{
                                        System.out.println("correo sin registro previo");
                                        if(co.validarUsuario(usuario) || usuario=="admin"){
                                            System.out.println("usuario con registro previo");
                                            response.sendRedirect("registrar.jsp");
                                        }else{
                                            if(co.IngresarPartida()){
                                                if(co.InsertarPersona(correo, nombre, appat, apmat, nac, genero, pais, estado)){
                                                    if(co.InsertaUsuario(usuario, password)){
                                                        response.sendRedirect("login.jsp");
                                                        
                                                    }else{
                                                        response.sendRedirect("errores/pagRota.jsp");
                                                    }
                                                }else{
                                                    response.sendRedirect("errores/pagRota.jsp");
                                                }
                                            }else{
                                            response.sendRedirect("errores/pagRota.jsp");
                                            }
                                        }
                                    }
                                }catch(Exception e) {
                                }
                            }else{
                                System.out.println("usuario y contraseña incorrecto");
                                response.sendRedirect("errores/errorCaracteres.jsp");
                            }
                        }else{
                            System.out.println("correo incorrecto");
                            response.sendRedirect("errores/errorCaracteres.jsp");
                        }
                    }else{
                        System.out.println("materno incorrecto");
                        response.sendRedirect("errores/errorCaracteres.jsp");
                    }
                }else{
                    System.out.println("paterno incorrecto");
                    response.sendRedirect("errores/errorCaracteres.jsp");
                }
            }else{
                System.out.println("nombre incorrecto");
                response.sendRedirect("errores/errorCaracteres.jsp");
            }
        }catch(Exception e) {
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
