import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    private static final String API_KEY = "TU_API_KEY_AQUI"; // <--- Aquí pones tu API Key

    public double buscaConversion(String monedaBase, String monedaObjetivo, double cantidad) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + API_KEY +
                    "/pair/" + monedaBase.toUpperCase() + "/" + monedaObjetivo.toUpperCase() + "/" + cantidad;
            System.out.println("URL de la API: " + url); // Debug: verifica que la URL sea correcta

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 400) {
                throw new RuntimeException("Solicitud inválida: revisa API Key y códigos de moneda.");
            }
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en API: código " + response.statusCode());
            }

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            if (!jsonObject.has("conversion_result")) {
                throw new RuntimeException("Respuesta inválida de la API");
            }

            return jsonObject.get("conversion_result").getAsDouble();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage(), e);
        }
    }
}

