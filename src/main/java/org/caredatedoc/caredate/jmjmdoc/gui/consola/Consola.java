package org.caredatedoc.caredate.jmjmdoc.gui.consola;

public class Consola {

    private static Consola consola;

    private Consola() {
    }

    public static Consola getInstance() {
        if (consola==null) {
            consola = new Consola();
        }
        return consola;
    }
}
