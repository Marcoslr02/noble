/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author CECyT9
 */
public class Conexion {
    private String USER = "root";
    private String PASSWORD = "n0m3l0";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "noble";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
    private Connection con;
    
    public Conexion(){
        try{
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(ClassNotFoundException e){
            System.err.println("Error:" + e);
        }
        catch(SQLException e){
            System.err.println("Error:" + e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
}

