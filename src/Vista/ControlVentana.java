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

/**
 *
 * @author DrkGodEater
 */
public class ControlVentana implements ActionListener{
    
    private VentanaSeleccion ventanaSeleccion;
    private VentanaPersonaje ventanaPersonaje;
    private Cliente cliente;

    public ControlVentana(Cliente cliente) {
        ventanaPersonaje = new VentanaPersonaje();
        ventanaSeleccion = new VentanaSeleccion();
        this.cliente = cliente;
        asignarOyentes();
        ventanaSeleccion.setVisible(true);
    }
    
    public void asignarOyentes(){
        ventanaPersonaje.volver.addActionListener(this);
        ventanaSeleccion.CrearPersonaje.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("CrearPersonaje")) {
            cliente.crearPersonaje((String) ventanaSeleccion.opciones.getSelectedItem());
            ventanaSeleccion.setVisible(false);
            cargarDatosPersonaje();
            ventanaPersonaje.setVisible(true);
        }
        if(comando.equals("volver")){
            ventanaPersonaje.setVisible(false);
            ventanaSeleccion.setVisible(true);
        }
    }
    
    public void cargarDatosPersonaje(){
    // Escalar y asignar imagen
    ImageIcon iconoCuerpo = new ImageIcon(cliente.cuerpo.darImagen());
    Image imagenCuerpoEscalada = iconoCuerpo.getImage().getScaledInstance(
        ventanaPersonaje.imagenCuerpo.getPreferredSize().width,
        ventanaPersonaje.imagenCuerpo.getPreferredSize().height,
        Image.SCALE_SMOOTH
    );
    ventanaPersonaje.imagenCuerpo.setIcon(new ImageIcon(imagenCuerpoEscalada));
    
    ImageIcon iconoArmadura = new ImageIcon(cliente.armadura.darImagen());
    Image imagenArmaduraEscalada = iconoArmadura.getImage().getScaledInstance(
        ventanaPersonaje.imagenArmadura.getPreferredSize().width,
        ventanaPersonaje.imagenArmadura.getPreferredSize().height,
        Image.SCALE_SMOOTH
    );
    ventanaPersonaje.imagenArmadura.setIcon(new ImageIcon(imagenArmaduraEscalada));
    
    ImageIcon iconoArma = new ImageIcon(cliente.arma.darImagen());
    Image imagenArmaEscalada = iconoArma.getImage().getScaledInstance(
        ventanaPersonaje.imagenArma.getPreferredSize().width,
        ventanaPersonaje.imagenArma.getPreferredSize().height,
        Image.SCALE_SMOOTH
    );
    ventanaPersonaje.imagenArma.setIcon(new ImageIcon(imagenArmaEscalada));
    
    ImageIcon iconoMontura = new ImageIcon(cliente.montura.darImagen());
    Image imagenMonturaEscalada = iconoMontura.getImage().getScaledInstance(
        ventanaPersonaje.imagenMontura.getPreferredSize().width,
        ventanaPersonaje.imagenMontura.getPreferredSize().height,
        Image.SCALE_SMOOTH
    );
    ventanaPersonaje.imagenMontura.setIcon(new ImageIcon(imagenMonturaEscalada));

    ventanaPersonaje.infoCuerpo.setText(cliente.cuerpo.darDescripcion());
    ventanaPersonaje.infoArmadura.setText(cliente.armadura.darDescripcion());
    ventanaPersonaje.infoArma.setText(cliente.arma.darDescripcion());
    ventanaPersonaje.infoMontura.setText(cliente.montura.darDescripcion());
}
    
    
    
    
}
