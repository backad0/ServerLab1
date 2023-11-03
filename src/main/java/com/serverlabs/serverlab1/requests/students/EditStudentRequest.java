package com.serverlabs.serverlab1.requests.students;

public class EditStudentRequest {
    private long id;
    private String name;
    private long idGroup;
    private String status;

    public EditStudentRequest(long idStudent, String name, long idGroup, String status) {
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

    public String getStatus() {
        return status;
    }

}
