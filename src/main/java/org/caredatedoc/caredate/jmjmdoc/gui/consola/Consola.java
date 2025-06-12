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
        System.out.println("1.- REGISTRO PACIENTE");
        System.out.println("2.- REGISTRO DIRECCIÓN");
        System.out.println("3.- SALIR");
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
        System.out.println("Opcion: " + opcion);

        switch (opcion) {
            case 1:
                ejecutable = RegistroPaciente.getInstance();
                break;
            case 2:
                ejecutable = ListaCatalogos.getInstance();
                break;
            case 3:
                System.out.println("Saliendo del sistema...");
                return;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        if (ejecutable != null) {
            ejecutable.setFlag(true);
            ejecutable.run();
        }
    }
}
