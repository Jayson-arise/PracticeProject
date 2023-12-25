package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AttendanceManager {
    private Section csc200SectionA;

    public AttendanceManager() {
        // Initialize or fetch Section data as needed
        // For simplicity, assuming that data is available
        // You may load data from a file or another source
    }

    // Fetch all data from the API
    public String getAllDataFromAPI() {
        return sendGetRequest("http://127.0.0.1:8000/api/all");
    }

    // Search for a student in the API
    public String searchStudentInAPI(String query) {
        String url = "http://127.0.0.1:8000/api/student/search?search=" + query;
        return sendGetRequest(url);
    }

    // Helper method to send GET requests
    private String sendGetRequest(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                return response.toString();
            } else {
                return "Error: " + responseCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
