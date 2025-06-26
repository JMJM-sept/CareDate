package org.caredatedoc.caredate.jmjmdoc.gui.consola.ventana;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame implements Ejecutable {

    @Override
    public void run() {

    }

    @Override
    public void setFlag(boolean flag) {

    }
}
/*
private JPanel panelPrincipal;

    private JRadioButton registroPaciente;
    private JRadioButton registroDireccion;
    private JButton botonSiguiente;

    private JTextField campoNombre;
    private JTextField campoApellidoPaterno;
    private JTextField campoApellidoMaterno;
    private JTextField campoCurp;
    private JTextField campoFechaNacimiento;
    private JTextField campoSexo;
    private JTextField campoCorreo;

    private JLabel etiquetaNombre;
    private JLabel etiquetaApellidoPaterno;
    private JLabel etiquetaApellidoMaterno;
    private JLabel etiquetaCurp;
    private JLabel etiquetaFechaNacimiento;
    private JLabel etiquetaSexo;
    private JLabel etiquetaCorreo;

    public Swing() {
        setTitle("BIENVENO A CAREDATE");
        setTitle("Seleccione una opción");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(4,1));

        registroPaciente = new JRadioButton("Registro de Paciente");
        registroDireccion = new JRadioButton("Registro de Dirección");

        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(registroPaciente);
        grupoBotones.add(registroDireccion);

        panelPrincipal.add(registroPaciente);
        panelPrincipal.add(registroDireccion);

 */
