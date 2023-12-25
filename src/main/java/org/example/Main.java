package org.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class Main {
    public static void main(String[] args) {
        // Create an instance of AttendanceManager
        AttendanceManager attendanceManager = new AttendanceManager();

        // Fetch all data from the API
        String allDataResponse = attendanceManager.getAllDataFromAPI();
        System.out.println("All Data from API:\n" + allDataResponse);

        // Search for a student in the API
        String searchResponse = attendanceManager.searchStudentInAPI("Almirante");
        System.out.println("Search Result:\n" + searchResponse);

        // Parse and display detailed information using ObjectMapper
        displayDetailedInformationWithObjectMapper(allDataResponse);
    }

    // Helper method to parse and display detailed information using ObjectMapper
    private static void displayDetailedInformationWithObjectMapper(String apiResponse) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode root = objectMapper.readTree(apiResponse);

            // Iterate over sections
            Iterator<Map.Entry<String, JsonNode>> sections = root.fields();
            while (sections.hasNext()) {
                Map.Entry<String, JsonNode> sectionEntry = sections.next();
                String sectionName = sectionEntry.getKey();
                JsonNode sectionNode = sectionEntry.getValue();

                System.out.println(sectionName + ":");

                // Iterate over sections (section-a, section-b, section-c)
                Iterator<Map.Entry<String, JsonNode>> classes = sectionNode.fields();
                while (classes.hasNext()) {
                    Map.Entry<String, JsonNode> classEntry = classes.next();
                    String className = classEntry.getKey();
                    JsonNode classNode = classEntry.getValue();

                    System.out.println("  " + className + ":");

                    // Iterate over students in each class
                    for (JsonNode studentNode : classNode.get("data")) {
                        Student student = objectMapper.treeToValue(studentNode, Student.class);
                        System.out.println("    ID: " + student.getId());
                        System.out.println("    Name: " + student.getName());

                        // Iterate over attendance
                        for (Attendance attendance : student.getAttendance()) {
                            System.out.println("      Date: " + attendance.getDate() + ", Present: " + attendance.isPresent());
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

