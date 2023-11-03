package com.serverlabs.serverlab1.requests.students;

public class AddStudentRequest {
    private String name;
    private long idGroup;
    private String status;

    public AddStudentRequest(String name, long idGroup, String status) {
        this.name = name;
        this.idGroup = idGroup;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public long getIdGroup() {
        return idGroup;
    }

    public String getStatus() {
        return status;
    }

}
