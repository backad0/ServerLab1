package com.serverlabs.serverlab1.entities;

import java.util.Objects;

public class StudentDB {
    private Long id;
    private String name;
    private Long groupId;
    private StudentStatus status;

    public StudentDB(Long id, String name, Long groupId, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getGroupId() {
        return groupId;
    }

    public StudentStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDB that = (StudentDB) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(groupId, that.groupId) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, groupId, status);
    }
}
