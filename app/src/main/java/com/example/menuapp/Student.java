package com.example.menuapp;

public class Student {
    String stName;
    String stFaculty;
    String stPhone;

    public Student(String stName, String stFaculty, String stPhone) {
        this.stName = stName;
        this.stFaculty = stFaculty;
        this.stPhone = stPhone;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStFaculty() {
        return stFaculty;
    }

    public void setStFaculty(String stFaculty) {
        this.stFaculty = stFaculty;
    }

    public String getStPhone() {
        return stPhone;
    }

    public void setStPhone(String stPhone) {
        this.stPhone = stPhone;
    }
}
