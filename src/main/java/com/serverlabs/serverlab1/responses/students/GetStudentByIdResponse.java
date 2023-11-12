package com.serverlabs.serverlab1.responses.students;


import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;

public class GetStudentByIdResponse {
    private StudentDB student;

    public GetStudentByIdResponse(StudentDB student) {
        this.student = student;
    }

    public StudentDB getStudent() {return student;}
}
