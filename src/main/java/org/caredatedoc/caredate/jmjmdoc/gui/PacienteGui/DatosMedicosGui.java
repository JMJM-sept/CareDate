package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class DatosMedicosGui extends JFrame {
    private JTextField sangreField;
    private JTextField alergiasField;
    private JTextField cronicasField;
    private JTextField medicamentosField;
    private JTextField cirugiasField;

    public DatosMedicosGui() {
        setTitle("Registro de Datos Médicos del Paciente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        panel.add(new JLabel("Tipo de Sangre (obligatorio):"));
        sangreField = new JTextField();
        panel.add(sangreField);

        panel.add(new JLabel("Alergias:"));
        alergiasField = new JTextField();
        panel.add(alergiasField);

        panel.add(new JLabel("Enfermedades Crónicas:"));
        cronicasField = new JTextField();
        panel.add(cronicasField);

        panel.add(new JLabel("Medicamentos (opcional):"));
        medicamentosField = new JTextField();
        panel.add(medicamentosField);

        panel.add(new JLabel("Cirugías Previas (opcional):"));
        cirugiasField = new JTextField();
        panel.add(cirugiasField);

        JButton terminarBtn = new JButton("Terminar Registro");
        panel.add(terminarBtn);

        // Espacio vacío para alinear el botón
        panel.add(new JLabel());

        add(panel);

        terminarBtn.addActionListener(e -> {
            if (sangreField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El tipo de sangre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            dispose(); // Cerrar ventana actual

            // Abrir selección de clínicas
            String seleccionarClinica = SeleccionClinicaGui.seleccionarClinica();

            if (seleccionarClinica != null) {
                JOptionPane.showMessageDialog(null, "Clínica seleccionada: " + seleccionarClinica);
                // Aquí puedes agregar código para continuar flujo con la clínica seleccionada
            }
        });
    }
}