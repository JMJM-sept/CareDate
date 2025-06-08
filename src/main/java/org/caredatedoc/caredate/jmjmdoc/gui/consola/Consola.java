package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

public class Consola extends LecturaAccion{

    private static Consola consola;

    private Consola() {
    }

    public static Consola getInstance() {
        if (consola==null) {
            consola = new Consola();
        }
        return consola;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("BIENVENIDO");
        System.out.println("Seleccione una opción");
        System.out.println("1.- Catálogos");
        System.out.println("2.- Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 2;
    }

    @Override
    public void procesaOpcion() {
        PENDIENTE
        }
    }



}
