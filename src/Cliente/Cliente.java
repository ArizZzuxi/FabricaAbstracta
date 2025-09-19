/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Fabricas.FabricaAbstracta;
import Fabricas.PoolFabricas;
import Productos.Arma;
import Productos.Armadura;
import Productos.Cuerpo;
import Productos.Montura;
import Vista.ControlVentana;

/**
 *
 * @author User
 */
public class Cliente {

    public PoolFabricas poolFabricas;
    public FabricaAbstracta fabrica;
    public Cuerpo cuerpo;
    public Armadura armadura;
    public Arma arma;
    public Montura montura;
    ControlVentana vista;

    public Cliente() {
        poolFabricas = PoolFabricas.getInstance();
        vista = new ControlVentana(this);
    }

    public void crearPersonaje(String opcion) {
        fabrica = poolFabricas.getFabrica(this, opcion);
        cuerpo = fabrica.crearCuerpo();
        armadura = fabrica.crearArmadura();
        arma = fabrica.crearArma();
        montura = fabrica.crearMontura();
    }
}
