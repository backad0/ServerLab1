package com.serverlabs.serverlab1.requests.students;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetStudentsByGroupRequest {
    private long id;

    @JsonCreator
    public GetStudentsByGroupRequest(@JsonProperty(value = "id")long idGroup) {
        this.id = idGroup;
    }

    public long getId() {
        return id;
    }
}
