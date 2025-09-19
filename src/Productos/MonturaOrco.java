/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class MonturaOrco implements Montura {

    private String descripcion;
    private String imagen;

    private static final String DESCRIPCION_DEFAULT = "Lobo de guerra, perfecto para el combate sin capacidad de carga";
    
    public MonturaOrco() {
        this.descripcion = DESCRIPCION_DEFAULT;
        imagen =  "src/Imagenes/MonturaOrco.png";
    }

    @Override
    public String darDescripcion() {
        return descripcion;
    }
    
    @Override
    public String darImagen() {
        return imagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
