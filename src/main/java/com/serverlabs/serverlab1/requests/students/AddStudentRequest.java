package com.serverlabs.serverlab1.requests.students;

import com.serverlabs.serverlab1.entities.StudentStatus;

public class AddStudentRequest {
    private String name;
    private long idGroup;
    private StudentStatus status;

    public AddStudentRequest(String name, long idGroup, StudentStatus status) {
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

    public StudentStatus getStatus() {
        return status;
    }

}
