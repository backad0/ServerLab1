package com.serverlabs.serverlab1.requests.students;

import com.serverlabs.serverlab1.entities.StudentDB;

public class EditStudentRequest {
    private StudentDB student;

    public EditStudentRequest(StudentDB student) {
        this.student = student;
    }

    public StudentDB getStudent(){return student;}
}
