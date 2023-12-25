package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.PrivateKey;

public class Attendance {
    private int id;
    private int schoolId;
    @JsonProperty("is_present")
    private boolean isPresent;
    private String date;

    public int getId() {
        return id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
