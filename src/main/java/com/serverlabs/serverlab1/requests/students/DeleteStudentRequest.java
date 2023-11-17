package com.serverlabs.serverlab1.requests.students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteStudentRequest {
    private long id;

    @JsonCreator
    public DeleteStudentRequest(@JsonProperty(value = "id")long idStudent) {
        this.id = idStudent;
    }

    public long getId() {
        return id;
    }

}
