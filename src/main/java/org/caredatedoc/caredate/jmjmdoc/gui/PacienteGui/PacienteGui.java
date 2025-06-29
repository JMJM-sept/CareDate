package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import org.caredatedoc.caredate.jmjmdoc.model.Paciente;

import javax.swing.*;
import java.awt.*;

public class PacienteGui extends JFrame {
    private JTextField nombreField;
    private JTextField aPaternoField;
    private JTextField aMaternoField;
    private JTextField curpField;
    private JTextField fechaNacField;
    private JTextField emailField;
    private JComboBox<String> sexoBox;

    public PacienteGui() {
        setTitle("Registro de Paciente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Apellido Paterno:"));
        aPaternoField = new JTextField();
        panel.add(aPaternoField);

        panel.add(new JLabel("Apellido Materno:"));
        aMaternoField = new JTextField();
        panel.add(aMaternoField);

        panel.add(new JLabel("CURP:"));
        curpField = new JTextField();
        panel.add(curpField);

        panel.add(new JLabel("Fecha de Nacimiento (YYYY-MM-DD):"));
        fechaNacField = new JTextField();
        panel.add(fechaNacField);

        panel.add(new JLabel("Sexo:"));
        sexoBox = new JComboBox<>(new String[]{"M", "F"});
        panel.add(sexoBox);

        panel.add(new JLabel("Correo Electrónico:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton registrarBtn = new JButton("Registrar");
        panel.add(registrarBtn);

        JButton cancelarBtn = new JButton("Cancelar");
        panel.add(cancelarBtn);

        add(panel);

        registrarBtn.addActionListener(e -> registrarPaciente());
        cancelarBtn.addActionListener(e -> dispose());
    }

    private void registrarPaciente() {
        try {
            Paciente paciente = new Paciente(
                    nombreField.getText(),
                    aPaternoField.getText(),
                    aMaternoField.getText(),
                    curpField.getText(),
                    fechaNacField.getText(),
                    emailField.getText(),
                    sexoBox.getSelectedItem().toString().charAt(0)
            );

            RegistroDomicilioGui domicilioGui = new RegistroDomicilioGui();
            domicilioGui.setVisible(true);

            dispose();

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(this, "Paciente registrado exitosamente.");
    }

}
