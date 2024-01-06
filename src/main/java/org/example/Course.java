package org.example;

import java.util.Map;

public class Course {

    // Map to store sections of the course, where the key is the section name and the value is the Section object.
    private Map<String, org.example.Section> csc200;

    /**
     * Getter method for accessing the sections of the course.
     *
     * @return Map of sections (section name to Section object).
     */
    public Map<String, org.example.Section> getcsc200() {

        return csc200;
    }
}
