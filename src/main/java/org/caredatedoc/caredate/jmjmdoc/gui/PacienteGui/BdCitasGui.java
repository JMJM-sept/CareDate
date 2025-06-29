package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BdCitasGui {
    // Mapa de clínica -> Lista de citas
    private static final Map<String, List<String>> citasPorClinica = new HashMap<>();

    // Guardar cita
    public static void agregarCita(String clinica, String cita) {
        citasPorClinica.computeIfAbsent(clinica, k -> new ArrayList<>()).add(cita);
    }

    // Obtener citas de una clínica
    public static java.awt.List obtenerCitas(String clinica) {
        return (java.awt.List) citasPorClinica.getOrDefault(clinica, new ArrayList<>());
    }

    public static void eliminarCita(String clinica, String cita) {
        List<String> citas = citasPorClinica.get(clinica);
        if (citas != null) {
            citas.remove(cita);
        }
    }
}
