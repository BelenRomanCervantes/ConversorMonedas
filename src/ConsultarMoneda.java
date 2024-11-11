import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public Moneda consultarMoneda(String base, String target, double cantidad){
        // OBTÉN https://v6.exchangerate-api.com/v6/ TU-CLAVE-API / par/ EUR / GBP / CANTIDAD
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6b95def54d9d85dce2cd2a32/pair/" + base + "/" + target + "/" + cantidad);


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Verificar el código de estado de la respuesta
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al obtener la tasa de conversión. Código de estado: " + response.statusCode() +
                        ". Respuesta: " + response.body());
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de conversión " + e.getMessage());
        }
    }



}
