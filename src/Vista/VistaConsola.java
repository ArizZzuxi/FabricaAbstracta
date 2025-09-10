package Vista;

import java.util.Scanner;


public class VistaConsola {
    Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }
    
    public void mostrarInformacion(String informacion) {
        System.out.println(informacion);
    }
    
    public int leerEntero(String informacion) {
        while (true) {
            try {
                mostrarInformacion(informacion);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: debe ingresar un número entero válido.");
            }
        }
    }
    
    public String leerCadena(String informacion) {
        mostrarInformacion(informacion);
        return scanner.nextLine();
    }
    
    public void cerrarEscaner() {
        scanner.close();
    }
    
    
}
