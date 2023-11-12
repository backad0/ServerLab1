package com.serverlabs.serverlab1.entities;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;
    private Group group;
    private StudentStatus status;

    public Student(Long id, String name, Group group, StudentStatus status) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public StudentStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(group, that.group) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, group, status);
    }
}
