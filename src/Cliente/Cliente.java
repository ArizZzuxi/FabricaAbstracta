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
                cuerpo = fabrica.crearCuerpo("Debil pero agil cuerpo de humano");
                armadura = fabrica.crearArmadura("Armadura de tela de bajo nivel, ofrece poca defensa");
                arma = fabrica.crearArma("Espada rota, poco mas que añadir al respecto");
                montura = fabrica.crearMontura("Mula, lenta pero confiable");
                return true;
            case 2:
                fabrica = new FabricaElfos();
                cuerpo = fabrica.crearCuerpo("Cuerpo de elfo, fragil pero con alta destreza y alerta sus alrededores");
                armadura = fabrica.crearArmadura("Armadura de cuero, excelente ante cuchilladas, debil ante golpes contundentes");
                arma = fabrica.crearArma("Arco de caza simple");
                montura = fabrica.crearMontura("Caballo blanco, rapido pero con poca capacidad de carga");
                return true;
            case 3:
                fabrica = new FabricaEnanos();
                cuerpo = fabrica.crearCuerpo("Cuerpo Pequeño de Enano, ofrece un aumento drastico de velocidad y sigilo");
                armadura = fabrica.crearArmadura("Ropa de tela simple, nula defensa alta, ofrece alto sigilo");
                arma = fabrica.crearArma("Daga simple, perfecto para asesinatos sigilosos");
                montura = fabrica.crearMontura("Oso de combate, lento pero con alto aguante y ataque");
                return true;
            case 4:
                fabrica = new FabricaOrcos();
                cuerpo = fabrica.crearCuerpo("Cuerpo De Orco, Especializado para combate");
                armadura = fabrica.crearArmadura("Armadura de guerra, Ofrece excelente defensa, visibilidad y velocidad reducida");
                arma = fabrica.crearArma("Hacha de guerra, lento con gran ataque");
                montura = fabrica.crearMontura("Lobo de guerra, perfecto para el combate sin capacidad de carga");
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
