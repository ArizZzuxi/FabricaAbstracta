/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Productos.Arma;
import Productos.ArmaElfo;
import Productos.Armadura;
import Productos.ArmaduraElfo;
import Productos.Cuerpo;
import Productos.CuerpoElfo;
import Productos.Montura;
import Productos.MonturaElfo;

/**
 *
 * @author User
 */
public class FabricaElfos implements FabricaAbstracta {

    @Override
    public Arma crearArma() {
        return new ArmaElfo();
    }

    @Override
    public Arma crearArma(String descripcion) {
        return new ArmaElfo();
    }

    @Override
    public Cuerpo crearCuerpo() {
        return new CuerpoElfo();
    }

    @Override
    public Cuerpo crearCuerpo(String descripcion) {
        return new CuerpoElfo();
    }

    @Override
    public Armadura crearArmadura() {
        return new ArmaduraElfo();
    }

    @Override
    public Armadura crearArmadura(String descripcion) {
        return new ArmaduraElfo();
    }

    @Override
    public Montura crearMontura() {
        return new MonturaElfo();
    }

    @Override
    public Montura crearMontura(String descripcion) {
        return new MonturaElfo();
    }

}
