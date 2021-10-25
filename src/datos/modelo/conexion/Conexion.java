/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class Conexion {
    
    private String bd="mysql2021";
    private String usuario="root";
    private String password="";
    private String url="jdbc:mysql://localhost/"+bd;
    private Connection conn=null;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url, usuario, password);
         //   System.out.println("Conecto en la Base de Datos "+bd);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
    
    
        
}
