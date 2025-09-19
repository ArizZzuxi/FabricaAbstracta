/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Fabricas;

import Cliente.Cliente;

/**
 *
 * @author DrkGodEater
 */
public class PoolFabricas {

    private static PoolFabricas instancia;
    private FabricaAbstracta fabrica;

    private PoolFabricas() {

    }

    public static PoolFabricas getInstance() {
        if (instancia == null) {
            instancia = new PoolFabricas();
        }
        return instancia;
    }

    public FabricaAbstracta getFabrica(Cliente cliente, String opcion) {
        // Si el cliente ya tiene una fábrica, verificar si la nueva opción es diferente
        if (cliente.fabrica != null) {
            String tipoActual = cliente.fabrica.getClass().getSimpleName();
            String tipoSolicitado = "Fabrica" + opcion + "s"; //  la s que falta

            if (!tipoActual.equals(tipoSolicitado)) {
                System.out.println("Cliente tiene " + tipoActual + " pero solicita " + tipoSolicitado
                        + ". Eliminando elementos y cambiando fabrica...");
                cliente.arma = null;
                cliente.armadura = null;
                cliente.cuerpo = null;
                cliente.montura = null;
            }
        }

        // Crear la nueva fábrica según la opción
        switch (opcion) {
            case "Humano":
                fabrica = new FabricaHumanos();
                return fabrica;
            case "Elfo":
                fabrica = new FabricaElfos();
                return fabrica;
            case "Enano":
                fabrica = new FabricaEnanos();
                return fabrica;
            case "Orco":
                fabrica = new FabricaOrcos();
                return fabrica;
            default:
                System.out.println("Opción de fábrica no válida: " + opcion);
                return null;
        }
    }
}
