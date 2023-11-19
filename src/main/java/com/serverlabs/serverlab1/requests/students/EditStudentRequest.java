package com.serverlabs.serverlab1.requests.students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;

public class EditStudentRequest {
    private StudentDB student;

    @JsonCreator
    public EditStudentRequest(@JsonProperty(value = "id")long id,
                              @JsonProperty(value = "name") String name,
                              @JsonProperty(value = "idGroup")long idGroup,
                              @JsonProperty(value = "status")StudentStatus status) {
        this.student = new StudentDB(id, name, idGroup, status);
    }

    public StudentDB getStudent(){return student;}
}
