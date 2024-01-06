package org.example;

import java.util.List;

public class Student {

    // Unique identifier for the student.
    private int id;

    // Name of the student.
    private String name;

    // List containing attendance records for the student.
    private List<AttendanceDate> attendance;

    /**
     * Getter method for retrieving the student's unique identifier.
     *
     * @return Integer representing the student's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter method for retrieving the student's name.
     *
     * @return String representing the student's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for retrieving the attendance records for the student.
     *
     * @return List of AttendanceDate objects representing the student's attendance.
     */
    public List<AttendanceDate> getAttendance() {
        return attendance;
    }
}
