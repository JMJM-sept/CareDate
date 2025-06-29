package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class RegistroDomicilioGui extends JFrame {
    public RegistroDomicilioGui() {
        setTitle("Registro de Domicilio del Paciente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        panel.add(new JLabel("Alcaldía:"));
        JTextField alcaldiaField = new JTextField();
        panel.add(alcaldiaField);

        panel.add(new JLabel("Colonia:"));
        JTextField coloniaField = new JTextField();
        panel.add(coloniaField);

        panel.add(new JLabel("Calle:"));
        JTextField calleField = new JTextField();
        panel.add(calleField);

        panel.add(new JLabel("Número:"));
        JTextField numeroField = new JTextField();
        panel.add(numeroField);

        panel.add(new JLabel("CP:"));
        JTextField cpField = new JTextField();
        panel.add(cpField);

        JButton siguienteBtn = new JButton("Siguiente");
        panel.add(siguienteBtn);

        // Espacio vacío para alinear el botón
        panel.add(new JLabel());

        add(panel);

        // Aquí agregamos el ActionListener que abre DatosMedicosGui
        siguienteBtn.addActionListener(e -> {
            DatosMedicosGui datosMedicosGui = new DatosMedicosGui();
            datosMedicosGui.setVisible(true);
            dispose();
        });
    }
}
