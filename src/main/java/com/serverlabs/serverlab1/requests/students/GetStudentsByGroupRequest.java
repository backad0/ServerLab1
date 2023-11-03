package com.serverlabs.serverlab1.requests.students;

public class GetStudentsByGroupRequest {
    private long id;

    public GetStudentsByGroupRequest(long idGroup) {
        this.id = idGroup;
    }

    public long getId() {
        return id;
    }
}
