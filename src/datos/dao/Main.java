/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import datos.entidad.Decano;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DecanoDao dao = new DecanoDao();
        //mostrarDecanos(dao);
        eliminarDecano(dao);
    }

    public static void mostrarDecanos(DecanoDao dao) {
        List<Decano> decanos = dao.decanos();
        System.out.println("***************************");
        if (decanos.size() == 0) {
            System.out.println("No se encontro Registros!!");
        } else {
            for (Decano decano : decanos) {
                decano.mostrar();
                System.out.println("***************************");
            }
        }
    }
    
    public static void guardarDecano(DecanoDao dao){
        Decano decano=new Decano("18","Juan","Perez",50);
        int ret=dao.guardarDecano(decano);
        String mensaje="";
        switch(ret){
            case 1:
            mensaje="Guardo con Exito!!";
            break;
            case 2:
            mensaje="Registro Existe";
            break;
        }
        System.out.println(mensaje);
    }
    
      public static void editarDecano(DecanoDao dao){
        Decano decano=new Decano("18","Juan 1","Perez 1",51);
        int ret=dao.editarDecano(decano);
        String mensaje="";
        switch(ret){
            case 1:
            mensaje="Actualizo con Exito!!";
            break;
            case 2:
            mensaje="No Actualizo Registro!!";
            break;
        }
        System.out.println(mensaje);
    }
      
    public static void eliminarDecano(DecanoDao dao){
         Decano decano=new Decano("19","Juan 1","Perez 1",51);
         dao.eliminarDecano(decano.getCoddec());
         mostrarDecanos(dao);
    }
    
    

}
