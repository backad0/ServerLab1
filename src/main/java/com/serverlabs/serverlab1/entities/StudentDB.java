package com.serverlabs.serverlab1.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class StudentDB implements Serializable {
    private Long id;
    private String name;
    private Long groupId;
    private StudentStatus status;

    @JsonCreator
    public StudentDB(@JsonProperty(value = "id")Long id,
                     @JsonProperty(value = "name")String name,
                     @JsonProperty(value = "groupId")Long groupId,
                     @JsonProperty(value = "status")StudentStatus status) {
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
