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

    private static final String DESCRIPCION_DEFAULT = "Armadura de tela de bajo nivel, ofrece poca defensa";
    
    public ArmaduraHumano() {
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
