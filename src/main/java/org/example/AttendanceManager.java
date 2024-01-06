package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URISyntaxException;
import java.io.IOException;

public class AttendanceManager {

    // This handles HTTP requests and responses.
    private static final HttpClient client = HttpClient.newHttpClient();

    // Base URI for the API
    private static final String BASE_URI = "http://127.0.0.1:8000/api";

    /**
     * Method for fetching data from a specific URI.
     *
     * @param dataURI The URI path for the data.
     * @return The response body as a string.
     */
    public static String getData(String dataURI) {
        try {
            // Building an HTTP GET request using the provided URI
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URI + dataURI))
                    .GET()
                    .build();

            // Sending the HTTP request and getting the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            // Handle exceptions and print stack trace
            e.printStackTrace();
            return "Error occurred while fetching data: " + e.getMessage();
        }
    }
}
