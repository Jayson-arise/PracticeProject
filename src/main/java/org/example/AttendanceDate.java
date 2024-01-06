package org.example;

public class AttendanceDate {

    // Boolean indicating whether the student is present or absent on a specific date.
    private boolean is_present;

    // Date for which the attendance is recorded.
    private String date;

    /**
     * Getter method for checking if the student is present.
     *
     * @return True if the student is present, false otherwise.
     */
    public boolean isIs_present() {
        return is_present;
    }

    /**
     * Getter method for retrieving the date for which the attendance is recorded.
     *
     * @return String representing the date of attendance.
     */
    public String getDate() {
        return date;
    }
}
