/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Fabricas.FabricaAbstracta;
import Fabricas.FabricaElfos;
import Fabricas.FabricaEnanos;
import Fabricas.FabricaHumanos;
import Fabricas.FabricaOrcos;
import Productos.Arma;
import Productos.Armadura;
import Productos.Cuerpo;
import Productos.Montura;
import Vista.VistaConsola;

/**
 *
 * @author User
 */
public class Cliente {

    FabricaAbstracta fabrica;
    Cuerpo cuerpo;
    Armadura armadura;
    Arma arma;
    Montura montura;
    VistaConsola vista;

    public Cliente() {
        vista = new VistaConsola();
        vista.mostrarInformacion("Bienvenido al juego de Rol, por favor escoja la raza de su personaje\n1)Humano\n2)Elfo\n3)Enano\n4)Orco");
        if(!crearPersonaje()) {
            vista.mostrarInformacion("Opcion no valida, intente nuevamente");
            vista.mostrarInformacion("1)Humano\n2)Elfo\n3)Enano\n4)Orco");
            crearPersonaje();
        }
        mostrarPersonaje();
        vista.cerrarEscaner();
    }

    public boolean crearPersonaje() {
        switch (vista.leerEntero("Digite la opcion que desee (1-4): ")) {
            case 1:
                fabrica = new FabricaHumanos();
                cuerpo = fabrica.crearCuerpo();
                armadura = fabrica.crearArmadura();
                arma = fabrica.crearArma();
                montura = fabrica.crearMontura();
                return true;
            case 2:
                fabrica = new FabricaElfos();
                cuerpo = fabrica.crearCuerpo();
                armadura = fabrica.crearArmadura();
                arma = fabrica.crearArma();
                montura = fabrica.crearMontura();
                return true;
            case 3:
                fabrica = new FabricaEnanos();
                cuerpo = fabrica.crearCuerpo();
                armadura = fabrica.crearArmadura();
                arma = fabrica.crearArma();
                montura = fabrica.crearMontura();
                return true;
            case 4:
                fabrica = new FabricaOrcos();
                cuerpo = fabrica.crearCuerpo();
                armadura = fabrica.crearArmadura();
                arma = fabrica.crearArma();
                montura = fabrica.crearMontura();
                return true;
            default:
                return false;
        }
    }
    public void mostrarPersonaje() {
        vista.mostrarInformacion("Felicidades, creaste tu personaje, aqui una descripcion:");
        vista.mostrarInformacion("Cuerpo: " + cuerpo.darDescripcion());
        vista.mostrarInformacion("Armadura: " + armadura.darDescripcion());
        vista.mostrarInformacion("Arma: " + arma.darDescripcion());
        vista.mostrarInformacion("Montura: " + montura.darDescripcion());
    }

}
