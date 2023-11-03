package com.serverlabs.serverlab1.requests.groups;

public class AddGroupRequest {
    private long id;
    private String name;

    public AddGroupRequest(String nameGroup, long idGroup) {
        this.name = nameGroup;
        this.id = idGroup;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
