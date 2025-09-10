/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Productos.Arma;
import Productos.ArmaEnano;
import Productos.Armadura;
import Productos.ArmaduraEnano;
import Productos.Cuerpo;
import Productos.CuerpoEnano;
import Productos.Montura;
import Productos.MonturaEnano;

/**
 *
 * @author User
 */
public class FabricaEnanos implements FabricaAbstracta {

    @Override
    public Arma crearArma() {
        return new ArmaEnano();
    }

    @Override
    public Arma crearArma(String descripcion) {
        return new ArmaEnano(descripcion);
    }

    @Override
    public Cuerpo crearCuerpo() {
        return new CuerpoEnano();
    }

    @Override
    public Cuerpo crearCuerpo(String descripcion) {
        return new CuerpoEnano(descripcion);
    }

    @Override
    public Armadura crearArmadura() {
        return new ArmaduraEnano();
    }

    @Override
    public Armadura crearArmadura(String descripcion) {
        return new ArmaduraEnano(descripcion);
    }

    @Override
    public Montura crearMontura() {
        return new MonturaEnano();
    }

    @Override
    public Montura crearMontura(String descripcion) {
        return new MonturaEnano(descripcion);
    }
}
