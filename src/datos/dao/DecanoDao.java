/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import java.sql.Connection;
import datos.modelo.conexion.Conexion;
import java.util.List;
import datos.entidad.Decano;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class DecanoDao {
    private Connection con;
    private PreparedStatement prep;
    public DecanoDao(){
        Conexion conexion=new Conexion();
        con=conexion.getConnection();
    }
    
    public List<Decano> decanos(){
        List<Decano> lista=new ArrayList<Decano>();
        String sql="select * from decano";
        try {
            prep=con.prepareStatement(sql);
            ResultSet rs=prep.executeQuery();
            while(rs.next()){
                lista.add(new Decano(rs.getString(1),rs.getString(2),
                                     rs.getString(3),rs.getInt(4)));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    public int guardarDecano(Decano decano){
        int ret=0;
        try{
            String sql="insert into decano values(?,?,?,?)";
            prep=con.prepareStatement(sql);
            prep.setString(1, decano.getCoddec());
            prep.setString(2, decano.getNomdec());
            prep.setString(3, decano.getApeldec());
            prep.setInt(4, decano.getEdad());
            ret=prep.executeUpdate();
        }
        catch(SQLException ex){
           if(ex.getErrorCode()==1062){
               ret=2;
           }
        }      
        
        return ret;
    }
    
    
    public int editarDecano(Decano decano){
        int ret=0;
        String sql="update decano set nomdec=?,apeldec=?,edad=? where coddec=?";
        try {
            prep=con.prepareStatement(sql);
            prep.setString(1, decano.getNomdec());
            prep.setString(2, decano.getApeldec());
            prep.setInt(3, decano.getEdad());
            prep.setString(4, decano.getCoddec());
            prep.executeUpdate();
            ret=1;
        } catch (SQLException ex) {
            ret=0;
        }
        
        return ret;
    }
    
    public void eliminarDecano(String coddec){
        
        String sql="delete from decano where coddec=?";
        try {
            prep=con.prepareStatement(sql);
            prep.setString(1, coddec);
            prep.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }              
        
    }
        
    
    
}
