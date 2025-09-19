/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class ArmaduraElfo implements Armadura {

    private String descripcion;
    
    private String imagen;

    private static final String DESCRIPCION_DEFAULT = "Armadura de cuero, excelente ante cuchilladas, debil ante golpes contundentes";
    
    public ArmaduraElfo() {
        this.descripcion = DESCRIPCION_DEFAULT;
        imagen =  "src/Imagenes/ArmaduraElfo.png";
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
