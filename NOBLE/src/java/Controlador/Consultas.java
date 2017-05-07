/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author CECyT9
 */
public class Consultas extends Conexion{
    public boolean autoidentificacion(String usuario, String contraseña){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String consulta = "select * from musuario where nomusuario = ? and contrasenia= ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        }
        catch(Exception e){
            System.err.println("Error: " +e);
        }
        finally{
            try {
                if(getConexion() != null)
                if(pst != null) pst.close(); 
                if(rs !=null) rs.close();
            } 
            catch (Exception e) {
                System.err.println("Error: " +e);
            }

        }
       return false; 
    } 
    
    //-----------------------------------------------------------------------------------------------------------------------------------------
    
    public boolean InsertarDet(String usuario, String comentario){
        PreparedStatement pst = null;
        try {
            String consulta= "insert into dcomus values((select idusuario from usuario where nick=? ), (select idcomentarios from comentarios where comentarios = ?))";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, comentario);

            if (pst.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try {
                 /*if(getConexion() != null){
                    getConexion().close();
                }*/
                 if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------------------------
    public boolean IngresarPartida(){
        PreparedStatement pst = null;
        try {
            String consulta= "insert into dpartida(vida,idmundo) values (default,default)";
            pst = getConexion().prepareStatement(consulta);

            if (pst.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
        return false;
    }
    
   
    
    public boolean InsertarPersona(String correo, String nombre, String appat, String apmat, String nac, String genero, String pais, String estado){
        PreparedStatement pst = null;
        try {
            String consulta= "insert into dpersona(correo,nombre,appat,apmat,fnac,genero,idestado,idpartida) values (?,?,?,?,?,?,(select E.idEstado from cestado E inner join cpais P on E .idpais=P.idpais where e.nomEstado=? and P.nompais=?),(SELECT (MAX(idpartida)) AS id FROM dpartida))";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            pst.setString(2, nombre);
            pst.setString(3, appat);
            pst.setString(4, apmat);
            pst.setString(5, nac);
            pst.setString(6, genero);
            pst.setString(7, estado);
            pst.setString(8, pais);

            if (pst.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try {
                 /*if(getConexion() != null){
                    getConexion().close();
                }*/
                 if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //insert into musuario(nomusuario,contrasenia,idpersona) values ('holi_123','123',(SELECT (MAX(idpersona)) AS id FROM dpersona));
    
    public boolean InsertaUsuario(String usuario, String contrasenia){
        PreparedStatement pst = null;
        try {
            String consulta= "insert into musuario(nomusuario,contrasenia,idpersona) values (?,?,(SELECT (MAX(idpersona)) AS id FROM dpersona))";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contrasenia);


            if (pst.executeUpdate() == 1) {
                return true;
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        finally{
            try {
                 /*if(getConexion() != null){
                    getConexion().close();
                }*/
                 if(pst != null) pst.close();
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
        }
        return false;
    }

    
}
