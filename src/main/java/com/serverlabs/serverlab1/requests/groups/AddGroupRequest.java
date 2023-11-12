package com.serverlabs.serverlab1.requests.groups;

public class AddGroupRequest {
    private String name;

    public AddGroupRequest(String nameGroup, long idGroup) {
        this.name = nameGroup;
    }

    public String getName() {
        return name;
    }
}
