package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalGui extends JFrame
{
    public MenuPrincipalGui() {
        setTitle("CareDate - Menú Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Bienvenido a CareDate", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo, BorderLayout.NORTH);

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.Y_AXIS));
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));

        JButton registrarPacienteBtn = new JButton("Registrar Paciente");
        JButton salirBtn = new JButton("Salir");

        registrarPacienteBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        salirBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonesPanel.add(Box.createVerticalStrut(10));
        botonesPanel.add(registrarPacienteBtn);
        botonesPanel.add(Box.createVerticalStrut(20));
        botonesPanel.add(salirBtn);
        botonesPanel.add(Box.createVerticalGlue());

        add(botonesPanel, BorderLayout.CENTER);

        registrarPacienteBtn.addActionListener(e -> {
            new PacienteGui().setVisible(true);
            this.dispose();
        });

        salirBtn.addActionListener(e -> System.exit(0));
    }
    public static void main(String[] args) {
        // Siempre recomendable correr Swing en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            MenuPrincipalGui menu = new MenuPrincipalGui();
            menu.setVisible(true);
        });
    }

}
