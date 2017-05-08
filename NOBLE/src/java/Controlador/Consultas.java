/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CECyT9
 */
public class Consultas extends Conexion{

public static Connection getConnection(){
        Connection con = null;
        String URL, Username, Password;
        URL= "jdbc:mysql://localhost:3306/noble";
        Username = "root";
        Password = "n0m3l0";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, Username, Password);
            System.out.println("Si conecto a la BD");
        } catch (Exception e) {
            System.out.println("No se conecto BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return con;
    }    
//----------------------------------------------------------------------------------------------------
    
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
    //---------------------------------------------------------------------------------------------------------------------------------
   public static List<Datos> getAllEmpleados(){
        List<Datos> lista = new ArrayList<>();
        try {
            Connection con = Consultas.getConnection();
            String sql = "select p.idpersona, p.nombre, p.correo, u.nomusuario, u.contrasenia"
                    + " from dpersona p inner join musuario u on p.idpersona=u.idpersona";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Datos e = new Datos();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setCorreo(rs.getString(3));
                e.setUsuario(rs.getString(4));
                e.setContrasena(rs.getString(5));
                lista.add(e);
            }
            
            System.out.println("Lo agrego");
            con.close();
        } catch (Exception d) {
            System.out.println("No lo agrego");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return lista;
    }
   
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------
   public static int Borrar(int id){
        int estado=0;
        try {
            Connection con = Consultas.getConnection();
            String sql = "call eliminar(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //e.getId cambia a id
            ps.setInt(1, id);
            
            estado = ps.executeUpdate();
            System.out.println("Lo borro");
            con.close();
        } catch (Exception d) {
            System.out.println("No lo borro");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return estado;
    }
   
   //---------------------------------------------------------------------------------------------------------------------
   public static Datos getUsuarioById(int id){
        Datos e = new Datos();
        try {
            Connection con = Consultas.getConnection();
            String sql = "select * from usuario where idpersona = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setCorreo(rs.getString(3));
                e.setUsuario(rs.getString(4));
                e.setContrasena(rs.getString(5));
                
            }
            else{
                // Mandar error
            }
            
            System.out.println("Lo agrego");
            con.close();
        } catch (Exception d) {
            System.out.println("No lo agrego");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return e;
    }
   
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
   public static int Actualizar(Datos e){
        int estado=0;
        try {
            Connection con = Consultas.getConnection();
            String sql = "call actualizar(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getCorreo());
            ps.setString(4, e.getUsuario());
            ps.setString(5, e.getContrasena());
            
            estado = ps.executeUpdate();
            System.out.println("Lo actualizo");
            con.close();
        } catch (Exception d) {
            System.out.println("No lo agrego");
            System.out.println(d.getMessage());
            System.out.println(d.getStackTrace());
        }
        return estado;
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------
   public boolean validarCorreo(String correo) throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            System.out.println("entro en el try de correo");
            String consulta = "select * from dpersona where correo= ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                System.out.println("rs.absolute(1)===true");
                return true;
                
            }
        }
        catch(Exception e){
            System.err.println("Error: " +e);
            System.out.println("salio del try de correo");
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
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------
    public boolean validarUsuario(String usuario)throws SQLException{
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            System.out.println("entro en el try de USUARIO");
            String consulta = "SELECT * FROM musuario WHERE nomusuario= ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                System.out.println("rs.absolute(1)===true");
                return true;
                
            }
        }
        catch(Exception e){
            System.err.println("Error: " +e);
            System.out.println("salio del try de correo");
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
    
}
