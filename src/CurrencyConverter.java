import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    private static final String API_key = "7fbee593c851ee49b8846b46";
    private static final String link = "https://v6.exchangerate-api.com/v6/" + API_key + "/latest/";


    public double converting (String moedaInicial, String moedaFinal, double quantidade) throws IOException, InterruptedException {
        String linkURL = link + moedaInicial;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(linkURL))
                .build();

        HttpResponse<String> resposta = cliente
                .send(requisicao, HttpResponse.BodyHandlers.ofString()); // request + response
        JsonObject jsonObject = JsonParser
                .parseString(resposta.body()).getAsJsonObject(); // Converte a resposta JSON em um objeto Java
        double taxaCambio = jsonObject
                .getAsJsonObject("conversion_rates").get(moedaFinal).getAsDouble(); // Obtém a taxa de câmbio da moeda final
        return quantidade * taxaCambio;
    }
}
