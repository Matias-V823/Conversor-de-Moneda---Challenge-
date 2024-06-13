import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsumoAPI {
    private static final String API_KEY = "INGRESA TU APIKEY";
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    public ConversionRates obtenerDatos(String moneda) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + API_KEY + "/latest/" + moneda))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();

        //Realizamos la serialización
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        ConversionRates rates = new ConversionRates();
        rates.setConversionRates(gson.fromJson(conversionRates, Map.class));
        return rates;
    }
}
