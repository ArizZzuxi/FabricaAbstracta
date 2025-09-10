/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Productos.Arma;
import Productos.ArmaOrco;
import Productos.Armadura;
import Productos.ArmaduraOrco;
import Productos.Cuerpo;
import Productos.CuerpoOrco;
import Productos.Montura;
import Productos.MonturaOrco;

/**
 *
 * @author User
 */
public class FabricaOrcos implements FabricaAbstracta {

    @Override
    public Arma crearArma() {
        return new ArmaOrco();
    }

    @Override
    public Arma crearArma(String descripcion) {
        return new ArmaOrco(descripcion);
    }

    @Override
    public Cuerpo crearCuerpo() {
        return new CuerpoOrco();
    }

    @Override
    public Cuerpo crearCuerpo(String descripcion) {
        return new CuerpoOrco(descripcion);
    }

    @Override
    public Armadura crearArmadura() {
        return new ArmaduraOrco();
    }

    @Override
    public Armadura crearArmadura(String descripcion) {
        return new ArmaduraOrco(descripcion);
    }

    @Override
    public Montura crearMontura() {
        return new MonturaOrco();
    }

    @Override
    public Montura crearMontura(String descripcion) {
        return new MonturaOrco(descripcion);
    }
}
