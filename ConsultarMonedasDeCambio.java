import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultarMonedasDeCambio {
    private static  final String API_KEY = ""; // Agregue su API entre las comillas

    public Moneda buscarMonedas(String monedaBase, String monedaTarget) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.body().contains("error")) {
                JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
                String errorType = jsonResponse.get("error_type").getAsString();
                throw new RuntimeException("Error de la API: " + errorType + ".Verifica las abreviaturas de las monedas.");
            }
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (java.io.IOException e){
            throw new RuntimeException("Error de conexión al buscar la moneda. Revisa tu conexión a internet.");
        } catch (java.lang.InterruptedException e) {
            throw new RuntimeException("La operación de búsqueda de monedas fue interrumpida.");
        } catch (com.google.gson.JsonSyntaxException e) {
            throw new RuntimeException("Error al procesar la respuesta de la API. Formato inesperado.");
        } catch (RuntimeException e) {
            throw e;
        }



    }
}
