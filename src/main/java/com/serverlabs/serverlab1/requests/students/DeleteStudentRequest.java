package com.serverlabs.serverlab1.requests.students;

public class DeleteStudentRequest {
    private long id;

    public DeleteStudentRequest(long idStudent) {
        this.id = idStudent;
    }

    public long getId() {
        return id;
    }

}
