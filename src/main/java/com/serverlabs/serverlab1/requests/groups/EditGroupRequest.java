package com.serverlabs.serverlab1.requests.groups;

public class EditGroupRequest {
    private long id;
    private String name;

    public EditGroupRequest(long idGroup, String nameGroup) {
        this.id = idGroup;
        this.name = nameGroup;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
