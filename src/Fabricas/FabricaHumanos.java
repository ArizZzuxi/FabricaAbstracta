/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fabricas;

import Productos.Arma;
import Productos.ArmaHumano;
import Productos.Armadura;
import Productos.ArmaduraHumano;
import Productos.Cuerpo;
import Productos.CuerpoHumano;
import Productos.Montura;
import Productos.MonturaHumano;

/**
 *
 * @author User
 */
public class FabricaHumanos implements FabricaAbstracta {

    @Override
    public Arma crearArma() {
        return new ArmaHumano();
    }

    @Override
    public Arma crearArma(String descripcion) {
        return new ArmaHumano(descripcion);
    }

    @Override
    public Cuerpo crearCuerpo() {
        return new CuerpoHumano();
    }

    @Override
    public Cuerpo crearCuerpo(String descripcion) {
        return new CuerpoHumano(descripcion);
    }

    @Override
    public Armadura crearArmadura() {
        return new ArmaduraHumano();
    }

    @Override
    public Armadura crearArmadura(String descripcion) {
        return new ArmaduraHumano(descripcion);
    }

    @Override
    public Montura crearMontura() {
        return new MonturaHumano();
    }

    @Override
    public Montura crearMontura(String descripcion) {
        return new MonturaHumano(descripcion);
    }
}
