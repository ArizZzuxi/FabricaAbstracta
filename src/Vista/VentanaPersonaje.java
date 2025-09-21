/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPersonaje extends JFrame {
    
    public JLabel imagenCuerpo, imagenArmadura, imagenArma, imagenMontura;
    public JLabel infoCuerpo, infoArmadura, infoArma, infoMontura;
    public JButton volver;
    
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JPanel footerPanel;
    private JScrollPane scrollPane;

    public VentanaPersonaje() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(true);
        setMinimumSize(new Dimension(900, 700));
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tu Personaje - RPG");
        
        // Panel principal con gradiente
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Gradiente de fondo
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(20, 30, 48),
                    0, getHeight(), new Color(36, 59, 85)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new BorderLayout());
        
        createHeader();
        createContent();
        createFooter();
        
        // Agregar paneles al panel principal
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setSize(1000, 800);
    }
    
    private void createHeader() {
        headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        
        JLabel titleLabel = new JLabel("Detalles del Personaje", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        headerPanel.add(titleLabel);
    }
    
    private void createContent() {
        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        
        // Crear tarjetas para cada elemento
        String[] elementos = {"Cuerpo", "Armadura", "Arma", "Montura"};
        JLabel[] imagenes = new JLabel[4];
        JLabel[] infos = new JLabel[4];
        
        // Inicializar componentes
        imagenCuerpo = createImageLabel();
        imagenArmadura = createImageLabel();
        imagenArma = createImageLabel();
        imagenMontura = createImageLabel();
        
        infoCuerpo = createInfoLabel();
        infoArmadura = createInfoLabel();
        infoArma = createInfoLabel();
        infoMontura = createInfoLabel();
        
        imagenes[0] = imagenCuerpo;
        imagenes[1] = imagenArmadura;
        imagenes[2] = imagenArma;
        imagenes[3] = imagenMontura;
        
        infos[0] = infoCuerpo;
        infos[1] = infoArmadura;
        infos[2] = infoArma;
        infos[3] = infoMontura;
        
        // Crear tarjetas en grid 2x2
        for (int i = 0; i < 4; i++) {
            JPanel card = createCharacterCard(elementos[i], imagenes[i], infos[i]);
            
            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            
            contentPanel.add(card, gbc);
        }
        
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    private void createFooter() {
        footerPanel = new JPanel();
        footerPanel.setOpaque(false);
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        
        // SOLUCIÓN: Establecer ActionCommand explícitamente
        volver = createStyledButton("← Volver a Selección", new Color(231, 76, 60));
        volver.setActionCommand("volver"); 
        footerPanel.add(volver);
    }
    
    private JPanel createCharacterCard(String title, JLabel imageLabel, JLabel infoLabel) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo de la tarjeta con transparencia
                g2d.setColor(new Color(255, 255, 255, 25));
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                
                // Borde sutil
                g2d.setColor(new Color(255, 255, 255, 50));
                g2d.setStroke(new BasicStroke(1));
                g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
            }
        };
        
        card.setLayout(new BorderLayout(10, 10));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        card.setOpaque(false);
        
        // Título de la tarjeta
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        // Panel para la imagen
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        imagePanel.setOpaque(false);
        imagePanel.add(imageLabel);
        
        // Configurar etiqueta de información
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setVerticalAlignment(SwingConstants.TOP);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(imagePanel, BorderLayout.CENTER);
        card.add(infoLabel, BorderLayout.SOUTH);
        
        // Efecto hover para la tarjeta
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                card.repaint();
            }
        });
        
        return card;
    }
    
    private JLabel createImageLabel() {
        JLabel label = new JLabel("Imagen no disponible", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(150, 120));
        label.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        label.setForeground(new Color(200, 200, 200));
        label.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(100, 100, 100), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        label.setOpaque(true);
        label.setBackground(new Color(50, 50, 50));
        return label;
    }
    
    private JLabel createInfoLabel() {
        JLabel label = new JLabel("<html><div style='text-align: center;'>Información del elemento</div></html>");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(new Color(220, 220, 220));
        label.setPreferredSize(new Dimension(200, 60));
        return label;
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
        button.setPreferredSize(new Dimension(220, 50));
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