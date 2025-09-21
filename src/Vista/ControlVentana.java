/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Cliente.Cliente;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

public class ControlVentana implements ActionListener {
    
    private VentanaSeleccion ventanaSeleccion;
    private VentanaPersonaje ventanaPersonaje;
    private Cliente cliente;
    private Timer fadeTimer;

    public ControlVentana(Cliente cliente) {
        this.cliente = cliente;
        initializeWindows();
        asignarOyentes();
        showVentanaSeleccion();
    }
    
    private void initializeWindows() {
        ventanaPersonaje = new VentanaPersonaje();
        ventanaSeleccion = new VentanaSeleccion();
        
        ventanaPersonaje.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ventanaSeleccion.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void showVentanaSeleccion() {
        SwingUtilities.invokeLater(() -> {
            ventanaSeleccion.setVisible(true);
            ventanaSeleccion.toFront();
            ventanaSeleccion.requestFocus();
        });
    }
    
    public void asignarOyentes() {
        ventanaPersonaje.volver.addActionListener(this);
        ventanaSeleccion.CrearPersonaje.addActionListener(this);
        
        // SOLUCIÓN: Establecer explícitamente el ActionCommand
        ventanaSeleccion.CrearPersonaje.setActionCommand("CrearPersonaje");
        ventanaPersonaje.volver.setActionCommand("volver");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        // Debug: Imprimir el comando recibido
        System.out.println("Comando recibido: '" + comando + "'");
        
        switch (comando) {
            case "CrearPersonaje":
                handleCrearPersonaje();
                break;
                
            case "volver":
                handleVolver();
                break;
                
            default:
                System.out.println("Comando no reconocido: '" + comando + "'");
                // Intentar manejar comandos alternativos
                if (comando.contains("Crear")) {
                    handleCrearPersonaje();
                } else if (comando.contains("volver") || comando.contains("Volver")) {
                    handleVolver();
                }
        }
    }
    
    private void handleCrearPersonaje() {
        try {
            System.out.println("Ejecutando handleCrearPersonaje()");
            
            // Deshabilitar botón temporalmente
            ventanaSeleccion.CrearPersonaje.setEnabled(false);
            ventanaSeleccion.CrearPersonaje.setText("Creando...");
            
            SwingUtilities.invokeLater(() -> {
                String razaSeleccionada = (String) ventanaSeleccion.opciones.getSelectedItem();
                System.out.println("Raza seleccionada: " + razaSeleccionada);
                
                cliente.crearPersonaje(razaSeleccionada);
                
                cargarDatosPersonaje();
                transitionToPersonajeWindow();
            });
            
        } catch (Exception ex) {
            System.err.println("Error al crear personaje: " + ex.getMessage());
            ex.printStackTrace();
            
            ventanaSeleccion.CrearPersonaje.setEnabled(true);
            ventanaSeleccion.CrearPersonaje.setText("Crear Personaje");
        }
    }
    
    private void handleVolver() {
        System.out.println("Ejecutando handleVolver()");
        transitionToSeleccionWindow();
    }
    
    private void transitionToPersonajeWindow() {
        SwingUtilities.invokeLater(() -> {
            ventanaSeleccion.setVisible(false);
            ventanaPersonaje.setVisible(true);
            ventanaPersonaje.toFront();
            ventanaPersonaje.requestFocus();
            
            ventanaSeleccion.CrearPersonaje.setEnabled(true);
            ventanaSeleccion.CrearPersonaje.setText("Crear Personaje");
        });
    }
    
    private void transitionToSeleccionWindow() {
        SwingUtilities.invokeLater(() -> {
            ventanaPersonaje.setVisible(false);
            ventanaSeleccion.setVisible(true);
            ventanaSeleccion.toFront();
            ventanaSeleccion.requestFocus();
        });
    }
    
    public void cargarDatosPersonaje() {
        try {
            cargarImagenComponente(cliente.cuerpo, ventanaPersonaje.imagenCuerpo);
            cargarImagenComponente(cliente.armadura, ventanaPersonaje.imagenArmadura);
            cargarImagenComponente(cliente.arma, ventanaPersonaje.imagenArma);
            cargarImagenComponente(cliente.montura, ventanaPersonaje.imagenMontura);
            
            cargarDescripcionComponente(cliente.cuerpo, ventanaPersonaje.infoCuerpo);
            cargarDescripcionComponente(cliente.armadura, ventanaPersonaje.infoArmadura);
            cargarDescripcionComponente(cliente.arma, ventanaPersonaje.infoArma);
            cargarDescripcionComponente(cliente.montura, ventanaPersonaje.infoMontura);
            
        } catch (Exception e) {
            System.err.println("Error al cargar datos del personaje: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void cargarImagenComponente(Object elemento, javax.swing.JLabel labelImagen) {
        try {
            if (elemento != null && elemento.getClass().getMethod("darImagen") != null) {
                String rutaImagen = (String) elemento.getClass().getMethod("darImagen").invoke(elemento);
                
                if (rutaImagen != null && !rutaImagen.trim().isEmpty()) {
                    ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
                    
                    if (iconoOriginal.getIconWidth() > 0 && iconoOriginal.getIconHeight() > 0) {
                        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                            labelImagen.getPreferredSize().width,
                            labelImagen.getPreferredSize().height,
                            Image.SCALE_SMOOTH
                        );
                        labelImagen.setIcon(new ImageIcon(imagenEscalada));
                        labelImagen.setText("");
                    } else {
                        setImagenPorDefecto(labelImagen, "Imagen no encontrada");
                    }
                } else {
                    setImagenPorDefecto(labelImagen, "Sin imagen");
                }
            } else {
                setImagenPorDefecto(labelImagen, "Elemento no disponible");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar imagen: " + e.getMessage());
            setImagenPorDefecto(labelImagen, "Error al cargar");
        }
    }
    
    private void cargarDescripcionComponente(Object elemento, javax.swing.JLabel labelInfo) {
        try {
            if (elemento != null && elemento.getClass().getMethod("darDescripcion") != null) {
                String descripcion = (String) elemento.getClass().getMethod("darDescripcion").invoke(elemento);
                
                if (descripcion != null && !descripcion.trim().isEmpty()) {
                    String descripcionFormateada = String.format(
                        "<html><div style='text-align: center; padding: 5px;'>%s</div></html>",
                        descripcion.length() > 100 ? descripcion.substring(0, 97) + "..." : descripcion
                    );
                    labelInfo.setText(descripcionFormateada);
                } else {
                    labelInfo.setText("<html><div style='text-align: center; font-style: italic;'>Sin descripción disponible</div></html>");
                }
            } else {
                labelInfo.setText("<html><div style='text-align: center; font-style: italic;'>Información no disponible</div></html>");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar descripción: " + e.getMessage());
            labelInfo.setText("<html><div style='text-align: center; font-style: italic; color: #ff6b6b;'>Error al cargar información</div></html>");
        }
    }
    
    private void setImagenPorDefecto(javax.swing.JLabel label, String mensaje) {
        label.setIcon(null);
        label.setText(mensaje);
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    }
    
    public void cleanup() {
        if (fadeTimer != null && fadeTimer.isRunning()) {
            fadeTimer.stop();
        }
        
        if (ventanaPersonaje != null) {
            ventanaPersonaje.dispose();
        }
        
        if (ventanaSeleccion != null) {
            ventanaSeleccion.dispose();
        }
    }
}