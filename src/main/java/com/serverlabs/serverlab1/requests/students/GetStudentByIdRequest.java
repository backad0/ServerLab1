package com.serverlabs.serverlab1.requests.students;

public class GetStudentByIdRequest {
    private long id;

    public GetStudentByIdRequest(long idStudent) {
        this.id = idStudent;
    }

    public long getId() {
        return id;
    }

}
