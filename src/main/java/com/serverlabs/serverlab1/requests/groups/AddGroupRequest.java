package com.serverlabs.serverlab1.requests.groups;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddGroupRequest {
    private String name;

    @JsonCreator
    public AddGroupRequest(@JsonProperty(value = "nameGroup") String nameGroup) {
        this.name = nameGroup;
    }

    public String getName() {
        return name;
    }
}
