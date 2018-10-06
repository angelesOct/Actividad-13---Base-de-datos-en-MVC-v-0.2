/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Salvador Hernandez Mendoza
 */
public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_nuevo) {
                jbtn_nuevo_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_borrar) {
                jbtn_Borrar_actionPerformed();
            }else if (e.getSource() == viewAgenda.jbtn_modificar) {
                jbtn_Modificar_actionPerformed();
            }  
        }
    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelAgenda.conectarDB();
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setTitle("Agenda MVC");
        viewAgenda.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jbtn_nuevo.addActionListener(actionListener);
        viewAgenda.jbtn_guardar.addActionListener(actionListener);
        viewAgenda.jbtn_modificar.addActionListener(actionListener);
        viewAgenda.jbtn_borrar.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelAgenda.conectarDB();
        modelAgenda.moverPrimerRegistro(); //se invoca al boton moverPrimerRegistro
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());//muestra el numbre en la vista
        viewAgenda.jtf_email.setText(modelAgenda.getEmail()); //muestra el email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelAgenda.moverAnteriorRegistro(); //se invoca al boton moverPrimerRegistro
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());//muestra el numbre en la vista
        viewAgenda.jtf_email.setText(modelAgenda.getEmail()); //muestra el email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelAgenda.moverUltimoRegistro(); //se invoca al boton moverPrimerRegistro
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());//muestra el numbre en la vista
        viewAgenda.jtf_email.setText(modelAgenda.getEmail()); //muestra el email en la vista
    }
    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelAgenda.moverSiguienteRegistro(); //se invoca al boton moverPrimerRegistro
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());//muestra el numbre en la vista
        viewAgenda.jtf_email.setText(modelAgenda.getEmail()); //muestra el email en la vista
    }
//*****************BOTONES Nuevo, Borrar, Guardar y Modificar**************************
     /**
     * Método para limpiar las cajas y proceder a ingresar un nuevo registro
     */
    private void jbtn_nuevo_actionPerformed(){
        viewAgenda.jtf_nombre.setText(modelAgenda.getLimpiar_cajas());//limpia la caja nombre
        viewAgenda.jtf_email.setText(modelAgenda.getLimpiar_cajas()); //limia la caja email
    }
    /**
     * Método para Guardar nuevos Registros
    */
    private void jbtn_guardar_actionPerformed(){
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); //Nuevo valor de nombre
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); // nuevo valor de email
        modelAgenda.Guardar();//llama al metodo Guardar
    }
    private void jbtn_Borrar_actionPerformed(){
        modelAgenda.Borrar();//llama al metodo Borrar 
    } 
    private void jbtn_Modificar_actionPerformed(){
        System.out.println("Action del boton jbtn_modificar");
        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); //Nuevo valor de nombre
        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); // nuevo valor de email
        modelAgenda.Modificar();//llama al metodo Modificar
    }
}
