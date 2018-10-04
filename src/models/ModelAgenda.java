/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Salvador Hernandez Mendoza
 */
public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private String nombre;
    private String email;
    private String limpiar_cajas="";

    public String getLimpiar_cajas() {
        return limpiar_cajas;
    }

    public void setLimpiar_cajas(String limpiar_cajas) {
        this.limpiar_cajas = limpiar_cajas;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que realiza las siguietnes acciones:
     * 1.- Conecta con la base agenda_mvc.
     * 2.- Consulta todo los registros de la tabla contactos.
     * 3.- Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/agenda_mvc","root","");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            nombre = rs.getString("nombre");
            email = rs.getString("email");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: " + err.getMessage());
        }

    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro(){
        System.out.print("Programa accion moverPrimerRegistro"); //verificar que la conexion MVC esta correcta
        try{             
            if(rs.isLast()==false) {                 
                rs.first();                 
                nombre = rs.getString("nombre");
                email = rs.getString("email");
            }         
        }catch(Exception err) {             
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
        } 
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al siguiente registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverSiguienteRegistro(){
        System.out.print("Programa accion moverSiguienteRegistro");//verificar que la conexion MVC esta correcta
        try{             
            if(rs.isLast()==false) {                 
                rs.next();                 
                nombre = rs.getString("nombre");
                email = rs.getString("email");                            
            } 
            else{
                rs.previous();
                JOptionPane.showMessageDialog(null,"ultimo registro");
            }
        }catch(Exception err) {             
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
        }
    }
    
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverAnteriorRegistro(){
        System.out.print("Programa accion moverAnteriorRegistro");//verificar que la conexion MVC esta correcta
        try{             
            if(rs.isLast()==false) {                 
                rs.previous();                 
                nombre = rs.getString("nombre");
                email = rs.getString("email"); 
            } 
            else{
                rs.next(); 
        }
        }catch(Exception err) {             
                JOptionPane.showMessageDialog(null,"primer registro");         
        }       
    }     
    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro(){
        System.out.print("Programa accion moverUltimoRegistro");//verificar que la conexion MVC esta correcta
        try{             
            if(rs.isLast()==false) {                 
                rs.last();                
                nombre = rs.getString("nombre");
                email = rs.getString("email");
            }         
        }catch(Exception err) {             
                JOptionPane.showMessageDialog(null,"Error "+err.getMessage());         
        }
    }
}
