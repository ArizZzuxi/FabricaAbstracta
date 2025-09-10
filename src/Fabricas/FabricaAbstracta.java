/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Fabricas;

import Productos.Arma;
import Productos.Armadura;
import Productos.Cuerpo;
import Productos.Montura;

/**
 *
 * @author User
 */
public interface FabricaAbstracta {
    
    public Cuerpo crearCuerpo();
    
    public Cuerpo crearCuerpo(String descripcion);
    
    public Armadura crearArmadura();
    
    public Armadura crearArmadura(String descripcion);
    
    public Arma crearArma();
    
    public Arma crearArma(String descripcion);
    
    public Montura crearMontura();
    
    public Montura crearMontura(String descripcion);
}
