package org.example;

import java.util.List;

public class Student {
    private int id;
    private int school_id;
    private String name;
    private List<Attendance> attendance;
    private String createdAt;
    private String updatedAt;


    public int getId() {
        return id;
    }

    public int getschool_id() {
        return school_id;
    }

    public String getName() {
        return name;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchoolId(int schoolId) {
        this.school_id = schoolId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
