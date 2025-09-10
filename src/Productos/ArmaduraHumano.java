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

    public ArmaduraHumano() {
    }

    public ArmaduraHumano(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String darDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
