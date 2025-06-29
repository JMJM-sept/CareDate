package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;
import java.util.Scanner;

public class ClinicasCatalogo implements Ejecutable {

    private static ClinicasCatalogo instancia;

    private ClinicasCatalogo() {
    }

    public static ClinicasCatalogo getInstance() {
        if (instancia == null) {
            instancia = new ClinicasCatalogo();
        }
        return instancia;
    }

    @Override
    public void run() {
        mostrarClinicasYMenu();
    }

    @Override
    public void setFlag(boolean flag) {
    }

    private void mostrarClinicasYMenu() {
        String[] clinicas = {
                "1. Av. Instituto Politécnico Nacional 123, Lindavista, Gustavo A. Madero",
                "2. Calzada de los Gallos 55, San Álvaro, Azcapotzalco",
                "3. Av. Universidad 460, Copilco, Coyoacán",
                "4. Av. Presidente Masaryk 112, Polanco, Miguel Hidalgo",
                "5. Av. Revolución 899, San Ángel, Álvaro Obregón",
                "6. Av. Insurgentes Sur 1432, Del Valle, Benito Juárez",
                "7. Prolongación División del Norte 307, Santa Cruz Acalpixca, Xochimilco",
                "8. Av. Montevideo 300, La Villa, Gustavo A. Madero",
                "9. Calle Clavería 100, Clavería, Azcapotzalco",
                "10. Calle Felipe Carrillo 140, Villa Coyoacán, Coyoacán",
                "11. Bahía de San Hipólito 250, Anzures, Miguel Hidalgo",
                "12. Calle 10 541, Olivar del Conde, Álvaro Obregón",
                "13. Av. Cuauhtémoc 500, Narvarte, Benito Juárez",
                "14. Calle Pino 150, San Mateo Xalpa, Xochimilco",
                "15. Calzada Ticomán 601, San Pedro Zacatenco, Gustavo A. Madero",
                "16. Calle Fresno 33, San Miguel Amantla, Azcapotzalco",
                "17. Calle Cerro del Agua 90, Pedregal de Santo Domingo, Coyoacán",
                "18. Av. Marina Nacional 212, Tacuba, Miguel Hidalgo",
                "19. Calle Goya 119, Colinas del Sur, Álvaro Obregón",
                "20. Av. Patriotismo 655, Nápoles, Benito Juárez"
        };

        System.out.println("::::: LISTA DE CLÍNICAS :::::");
        for (String clinica : clinicas) {
            System.out.println(clinica);
        }

        System.out.println("MENÚ DE PACIENTE");
        System.out.println("1. Agendar cita");
        System.out.println("2. Cancelar cita");
        System.out.println("3. Consultar historial de citas");
        System.out.println("4. Editar datos médicos");
        System.out.println("5. Salir");

        Scanner sc = new Scanner(System.in);
        System.out.print("Selecciona una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Has elegido: Agendar cita");

                break;
            case 2:
                System.out.println("Has elegido: Cancelar cita");
                break;
            case 3:
                System.out.println("Has elegido: Consultar historial");
                break;
            case 4:
                System.out.println("Por implementar");
            case 5:
                System.out.println("Saliendo de MENÚ DE PACIENTE");
                return;
            default:
                System.out.println("Opción inválida");
        }
    }
}
