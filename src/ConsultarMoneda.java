import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConsultarMoneda {
    // OBTÉN https://v6.exchangerate-api.com/v6/ TU-CLAVE-API / par/ EUR / GBP / CANTIDAD
    URI direccion = URI.create("https://v6.exchangerate-api.com/v6/6b95def54d9d85dce2cd2a32/pair/" + base + "/" + target + "/" + cantidad);


    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
            .uri(direccion)
            .build();

}
