package com.serverlabs.serverlab1.responses.groups;

import com.serverlabs.serverlab1.entities.Group;

public class GetGroupByIdResponse {
    private Group group;

    public GetGroupByIdResponse(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }
}
