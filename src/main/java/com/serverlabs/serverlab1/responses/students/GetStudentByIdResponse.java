package com.serverlabs.serverlab1.responses.students;


import com.serverlabs.serverlab1.entities.StudentStatus;

public class GetStudentByIdResponse {
    private long id;
    private String name;
    private long idGroup;
    private StudentStatus status;

    public GetStudentByIdResponse(long idStudent, String name, long idGroup, StudentStatus status) {
        this.id = idStudent;
        this.name = name;
        this.idGroup = idGroup;
        this.status = status;
    }

    public long getId() {
        return id;
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
