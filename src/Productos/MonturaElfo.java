/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class MonturaElfo implements Montura {

    private String descripcion;

    private static final String DESCRIPCION_DEFAULT = "Caballo blanco, rapido pero con poca capacidad de carga";
    
    public MonturaElfo() {
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
