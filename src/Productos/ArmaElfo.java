/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class ArmaElfo implements Arma{
    
    private String descripcion;

    private static final String DESCRIPCION_DEFAULT = "Arco de caza con una ligera daga y un carcaj lleno de flechas";
    
    public ArmaElfo() {
        this.descripcion = DESCRIPCION_DEFAULT;
    }

    @Override
    public String darDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
