package com.serverlabs.serverlab1.requests.groups;

public class GetGroupByIdRequest {
    private long id;

    public GetGroupByIdRequest(long idGroup) {
        this.id = idGroup;
    }

    public long getId() {
        return id;
    }
}
