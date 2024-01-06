package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // For deserialization (from JSON to string)
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                // Display menu options
                System.out.println("""
                        \nATTENDANCE RECORD
                        
                        1. Display All Data
                        2. Search Student
                        3. Exit
                        Enter:\s""");

                byte userInput = scanner.nextByte();

                if (userInput == 1) {
                    // Display all data
                    String response = AttendanceManager.getData("/all");
                    displayAllData(response);
                } else if (userInput == 2) {
                    // Search for a student
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    String response = AttendanceManager.getData("/student/search?search=" + studentName);
                    searchStudentData(response);
                } else {
                    // Exit the program
                    System.out.println("Bye.");
                    break;
                }
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    public static void displayAllData(String data) throws JsonProcessingException {
        // Deserialize JSON response to Course object
        Course course = objectMapper.readValue(data, Course.class);
        System.out.println("Course: CSC200");

        // Iterate through sections of the course
        for (Map.Entry<String, Section> section : course.getcsc200().entrySet()) {
            System.out.println("\nSection: " + section.getKey());

            Section sectionData = section.getValue();
            System.out.println("Total Students: " + sectionData.getTotal_students());

            // Display data for each student in the section
            System.out.println("Data: ");
            List<Student> students = sectionData.getStudentsInSection();

            // Iterate through the students of a section
            for (Student student : students) {
                System.out.println();
                System.out.println("Student ID: " + student.getId());
                System.out.println("Student Name: " + student.getName());

                System.out.println("Attendance: ");
                for (AttendanceDate attendances : student.getAttendance()) {
                    // Display attendance information
                    if (attendances.isIs_present()) {
                        System.out.println("Present: " + attendances.getDate());
                    } else {
                        System.out.println("Absent: " + attendances.getDate());
                    }
                }
            }
        }
    }

    public static void searchStudentData(String data) throws JsonProcessingException {
        // Read JSON data and create a JSON tree structure
        JsonNode rootNode = objectMapper.readTree(data);
        JsonNode csc200Node = rootNode.get("csc200");
        System.out.println("Course: CSC200");

        JsonNode dataNode = csc200Node.get("data");

        if (dataNode != null) {
            // The iterator fieldsIterator loops through the fields (key-value pairs)
            // of the JSON object (dataNode) to access each field individually
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = dataNode.fields();

            while (fieldsIterator.hasNext()) {
                Map.Entry<String, JsonNode> section = fieldsIterator.next();

                System.out.println("\nSection: " + section.getKey());

                JsonNode studentsNode = section.getValue();

                for (JsonNode student : studentsNode) {
                    System.out.println();
                    System.out.println("Student ID: " + student.get("id").asInt());
                    System.out.println("Student Name: " + student.get("name").asText());

                    JsonNode attendanceNode = student.get("attendance");
                    System.out.println("Attendance: ");

                    for (JsonNode attendances : attendanceNode) {
                        boolean isPresent = attendances.get("is_present").asBoolean();

                        if (isPresent) {
                            System.out.println("Present: " + attendances.get("date").asText());
                        } else {
                            System.out.println("Absent: " + attendances.get("date").asText());
                        }
                    }
                }
            }
        }
    }
}
