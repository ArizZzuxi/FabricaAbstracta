/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class ArmaHumano implements Arma{
    private String descripcion;

    private static final String DESCRIPCION_DEFAULT = "Una gran espada larga de buen material";
    
    public ArmaHumano() {
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
