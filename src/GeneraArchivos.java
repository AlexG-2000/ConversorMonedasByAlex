import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneraArchivos {
    private static final String ARCHIVO = "historial_consultas.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void guardarHistorial(List<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay datos para guardar.");
            return;
        }

        try (FileWriter fileWriter = new FileWriter(ARCHIVO)) {
            gson.toJson(lista, fileWriter);
            System.out.println("Historial de consultas guardado en '" + ARCHIVO + "'");
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}

