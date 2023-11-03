package com.serverlabs.serverlab1.requests.groups;

public class DeleteGroupRequest {
    private long id;

    public DeleteGroupRequest(long idGroup) {
        this.id = idGroup;
    }

    public long getId() {
        return id;
    }
}
