package com.serverlabs.serverlab1.requests.groups;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetGroupByIdRequest {
    private long id;

    @JsonCreator
    public GetGroupByIdRequest(@JsonProperty(value = "id")long idGroup) {
        this.id = idGroup;
    }

    public long getId() {
        return id;
    }
}
