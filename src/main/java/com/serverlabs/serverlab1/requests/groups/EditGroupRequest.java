package com.serverlabs.serverlab1.requests.groups;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.serverlabs.serverlab1.entities.Group;

public class EditGroupRequest {
    private Group group;

    @JsonCreator
    public EditGroupRequest(@JsonProperty(value = "group")Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
