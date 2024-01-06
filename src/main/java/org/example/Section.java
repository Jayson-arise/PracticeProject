package org.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Section {

    // Total number of students in the section.
    @JsonProperty("total_students")
    private int total_students;

    // List containing student objects for the section.
    @JsonProperty("data")
    private List<Student> studentsInSection;

    /**
     * Getter method for retrieving the total number of students in the section.
     *
     * @return Integer representing the total number of students.
     */
    public int getTotal_students() {
        return total_students;
    }

    /**
     * Getter method for retrieving the list of students in the section.
     *
     * @return List of Student objects representing the students in the section.
     */
    public List<Student> getStudentsInSection() {
        return studentsInSection;
    }
}
