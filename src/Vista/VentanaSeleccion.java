/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSeleccion extends JFrame {
    
    public JComboBox<String> opciones;
    public JButton CrearPersonaje;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JPanel footerPanel;

    public VentanaSeleccion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Creador de Personajes - RPG");
        
        // Panel principal con gradiente
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Gradiente de fondo
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(45, 52, 54),
                    0, getHeight(), new Color(99, 110, 114)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());
        
        // Panel de encabezado
        headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        
        titleLabel = new JLabel("Crear Nuevo Personaje", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(titleLabel);
        
        // Panel de contenido
        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        // Label para selección de raza
        JLabel raceLabel = new JLabel("Selecciona la raza de tu personaje:");
        raceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        raceLabel.setForeground(Color.WHITE);
        raceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        raceLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        contentPanel.add(raceLabel);
        
        // ComboBox estilizado
        opciones = new JComboBox<>(new String[]{"Humano", "Elfo", "Orco", "Enano"});
        opciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        opciones.setPreferredSize(new Dimension(250, 40));
        opciones.setMaximumSize(new Dimension(250, 40));
        opciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Personalizar ComboBox
        opciones.setBackground(Color.WHITE);
        opciones.setForeground(new Color(45, 52, 54));
        opciones.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(116, 185, 255), 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(opciones);
        
        // Panel de pie de página
        footerPanel = new JPanel();
        footerPanel.setOpaque(false);
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        
        // Botón estilizado - SOLUCIÓN: Establecer ActionCommand explícitamente
        CrearPersonaje = createStyledButton("Crear Personaje", new Color(46, 204, 113));
        CrearPersonaje.setActionCommand("CrearPersonaje"); // ¡IMPORTANTE!
        footerPanel.add(CrearPersonaje);
        
        // Agregar paneles al panel principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setSize(600, 500);
    }
    
    private JButton createStyledButton(String text, Color baseColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                Color currentColor = baseColor;
                if (getModel().isPressed()) {
                    currentColor = currentColor.darker();
                } else if (getModel().isRollover()) {
                    currentColor = currentColor.brighter();
                }
                
                // Gradiente del botón
                GradientPaint gradient = new GradientPaint(
                    0, 0, currentColor,
                    0, getHeight(), currentColor.darker()
                );
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
                
                // Texto del botón
                g2d.setColor(Color.WHITE);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g2d.drawString(getText(), x, y);
            }
        };
        
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(200, 50));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Efectos hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.repaint();
            }
        });
        
        return button;
    }
}