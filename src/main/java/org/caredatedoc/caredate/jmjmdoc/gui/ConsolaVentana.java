package org.caredatedoc.caredate.jmjmdoc.gui;

import org.caredatedoc.caredate.jmjmdoc.gui.consola.Consola;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.LecturaAccion;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.ventana.Ventana;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

public class ConsolaVentana extends LecturaAccion {

    public static ConsolaVentana consolaVentana;

    private ConsolaVentana() {
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione la opción");
        System.out.println("1.- Consola");
        System.out.println("2.- Ventana");
        System.out.println("3.- Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 3;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;
        if (opcion == 1) {
            ejecutable = (Ejecutable) Consola.getInstance();
        }
        if (opcion == 2) {
            ejecutable = Ventana.getInstance();
        }
        ejecutable.setFlag(true);
        ejecutable.run();
    }
}
