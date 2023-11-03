package com.serverlabs.serverlab1.responses.groups;

public class GetGroupByIdResponse {
    private long id;
    private String name;

    public GetGroupByIdResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
