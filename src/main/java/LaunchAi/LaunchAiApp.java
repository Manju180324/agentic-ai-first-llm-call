
package LaunchAi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class LaunchAiApp {

    public static void main(String[] args) throws Exception {

        String apiKey = System.getenv("API_KEY");

        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "API_KEY environment variable is not set"
            );
        }

        String requestBody = """
                {
                    "model": "gpt-5.6-luna",
                    "input": "Explain Java"
                }
                """;

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/responses"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .timeout(Duration.ofSeconds(60))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

//        System.out.println("Status Code: " + response.statusCode());
//        System.out.println("Response Body:");
        System.out.println(response.body());
    }
}


