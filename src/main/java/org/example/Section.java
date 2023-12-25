package org.example;

import java.util.List;

public class Section {
    private int totalStudents;
    private List<Student> data;


    public int getTotalStudents() {
        return totalStudents;
    }

    public List<Student> getData() {
        return data;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
}
