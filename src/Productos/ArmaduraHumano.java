/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class ArmaduraHumano implements Armadura{
    private String descripcion;
    private String imagen;
    private static final String DESCRIPCION_DEFAULT = "Armadura de cota de malla y accesorios metalicos, limita el movimiento pero tiene buena defensa";
    
    public ArmaduraHumano() {
        this.descripcion = DESCRIPCION_DEFAULT;
        imagen =  "src/Imagenes/ArmaduraHumano.png";
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
