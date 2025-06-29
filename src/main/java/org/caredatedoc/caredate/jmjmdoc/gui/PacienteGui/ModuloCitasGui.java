package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class ModuloCitasGui extends JFrame {

    public ModuloCitasGui(String clinicaSeleccionada) {
        setTitle("Módulo de Citas - " + clinicaSeleccionada);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Gestión de Citas en " + clinicaSeleccionada, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));

        JButton agendarBtn = new JButton("Agendar Cita");
        JButton consultarBtn = new JButton("Consultar Citas");
        JButton eliminarBtn = new JButton("Eliminar Cita");

        panelBotones.add(agendarBtn);
        panelBotones.add(consultarBtn);
        panelBotones.add(eliminarBtn);

        add(panelBotones, BorderLayout.CENTER);

        // Acción para agendar
        agendarBtn.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                AgendarCitaGui agendarCitaGui = new AgendarCitaGui(); // Asegúrate que esta clase exista
                agendarCitaGui.setVisible(true);
            });
        });

        // Acción para consultar
        consultarBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(ModuloCitasGui.this, "Consultar citas para " + clinicaSeleccionada)
        );

        // Acción para eliminar
        eliminarBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(ModuloCitasGui.this, "Eliminar cita para " + clinicaSeleccionada)
        );
    }
}

