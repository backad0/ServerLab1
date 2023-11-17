package com.serverlabs.serverlab1.requests.groups;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteGroupRequest {
    private long id;

    @JsonCreator
    public DeleteGroupRequest(@JsonProperty(value = "id")long idGroup) {
        this.id = idGroup;
    }

    public long getId() {
        return id;
    }
}
