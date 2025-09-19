/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class MonturaHumano implements Montura {

    private String descripcion;
    private String imagen;

    private static final String DESCRIPCION_DEFAULT = "Caballo con armadura y alforjas";
    
    public MonturaHumano() {
        this.descripcion = DESCRIPCION_DEFAULT;
        imagen =  "src/Imagenes/MonturaHumano.jpg";
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
