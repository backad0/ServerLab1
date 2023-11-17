package com.serverlabs.serverlab1.requests.students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverlabs.serverlab1.entities.StudentDB;

public class EditStudentRequest {
    private StudentDB student;

    @JsonCreator
    public EditStudentRequest(@JsonProperty(value = "student")StudentDB student) {
        this.student = student;
    }

    public StudentDB getStudent(){return student;}
}
