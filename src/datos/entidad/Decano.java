/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidad;

/**
 *
 * @author DELL
 */
public class Decano {
    private String coddec;
    private String nomdec;
    private String apeldec;
    private int edad;

    public Decano(String coddec, String nomdec, String apeldec, int edad) {
        this.coddec = coddec;
        this.nomdec = nomdec;
        this.apeldec = apeldec;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCoddec() {
        return coddec;
    }

    public void setCoddec(String coddec) {
        this.coddec = coddec;
    }

    public String getNomdec() {
        return nomdec;
    }

    public void setNomdec(String nomdec) {
        this.nomdec = nomdec;
    }

    public String getApeldec() {
        return apeldec;
    }

    public void setApeldec(String apeldec) {
        this.apeldec = apeldec;
    }
    
    public void mostrar(){
        System.out.println("Codigo Decano "+coddec);
        System.out.println("Nombre Decano "+nomdec);
        System.out.println("Apellido Decano "+apeldec);
        System.out.println("Edad Decano "+edad);
    }
       
        
    
}
