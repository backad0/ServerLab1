package com.serverlabs.serverlab1.requests.students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverlabs.serverlab1.entities.StudentStatus;

public class AddStudentRequest {
    private String name;
    private long idGroup;
    private StudentStatus status;

    @JsonCreator
    public AddStudentRequest(@JsonProperty(value = "name")String name,
                             @JsonProperty(value = "idGroup") long idGroup,
                             @JsonProperty(value = "status") StudentStatus status) {
        this.name = name;
        this.idGroup = idGroup;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public StudentStatus getStatus() {
        return status;
    }

}

