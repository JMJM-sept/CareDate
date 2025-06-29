package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgendarCitaGui extends JFrame {

    private JSpinner dateSpinner;
    private JComboBox<String> horarioCombo;

    public AgendarCitaGui() {
        setTitle("Agendar Cita");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        // ---------- Fecha con JSpinner ----------
        add(new JLabel("Seleccione la fecha:"));

        SpinnerDateModel spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(spinnerModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(editor);
        add(dateSpinner);

        // ---------- Horarios ----------
        add(new JLabel("Seleccione el horario:"));
        horarioCombo = new JComboBox<>();
        add(horarioCombo);
        actualizarHorariosDisponibles();

        // ---------- Botón Agendar ----------
        JButton agendarBtn = new JButton("Agendar Cita");
        add(agendarBtn);
        agendarBtn.addActionListener(e -> agendarCita());
    }

    private void actualizarHorariosDisponibles() {
        horarioCombo.removeAllItems();
        String[] horarios = {
                "09:00 AM", "10:00 AM", "11:00 AM",
                "01:00 PM", "02:00 PM", "03:00 PM"
        };
        for (String h : horarios) {
            horarioCombo.addItem(h);
        }
    }

    private void agendarCita() {
        Date fecha = (Date) dateSpinner.getValue();
        String horario = (String) horarioCombo.getSelectedItem();

        if (fecha == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (horario == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un horario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = sdf.format(fecha);

        JOptionPane.showMessageDialog(this,
                "Cita agendada para el " + fechaStr + " a las " + horario + ".");
        dispose();
    }

}
