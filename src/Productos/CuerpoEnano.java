/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productos;

/**
 *
 * @author User
 */
public class CuerpoEnano implements Cuerpo {

    private String descripcion;

    private static final String DESCRIPCION_DEFAULT = "Cuerpo Pequeño de Enano, ofrece un aumento drastico de velocidad y sigilo";
    
    public CuerpoEnano() {
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
