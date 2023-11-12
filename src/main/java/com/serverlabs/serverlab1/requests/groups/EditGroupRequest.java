package com.serverlabs.serverlab1.requests.groups;

import com.serverlabs.serverlab1.entities.Group;

public class EditGroupRequest {
    private Group group;

    public EditGroupRequest(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
