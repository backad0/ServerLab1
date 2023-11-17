package com.serverlabs.serverlab1.database.repositories;


import com.serverlabs.serverlab1.database.Database;
import com.serverlabs.serverlab1.database.IStudentRepo;
import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;
import com.serverlabs.serverlab1.excepcions.RepositoryException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentRepo implements IStudentRepo {
    private Database db;
    long counter;

    public StudentRepo(Database db) {
        this.db = db;
        counter = 0;
    }

    @Override
    public long addStudent(String name, long groupId, StudentStatus status) throws RepositoryException {
        Map<Long, StudentDB> studentMap = db.getStudentsTable();
        long key;
        if (studentMap.keySet().isEmpty()) {
            key = 0;
        } else {
            key = ++counter;
        }
        studentMap.put(key, new StudentDB(key, name, groupId, status));
        return key;
    }

    @Override
    public void deleteStudent(long id) throws RepositoryException {
        if (!db.getStudentsTable().containsKey(id)) throw new RepositoryException("Not contains exact key");
        db.getStudentsTable().remove(id);
    }

    @Override
    public void editStudent(StudentDB student) throws RepositoryException {
        if (!db.getStudentsTable().containsKey(student.getId())) throw new RepositoryException("Not contains exact student");
        db.getStudentsTable().replace(student.getId(), student);
    }

    @Override
    public StudentDB getStudentById(long id) throws RepositoryException {
        if (!db.getStudentsTable().containsKey(id)) throw new RepositoryException("Not contains exact key");
        return db.getStudentsTable().get(id);
    }

    @Override
    public List<Student> getStudentByIdGroup(long idGroup) throws RepositoryException {
        return db.getStudentsTable().values().stream().filter(v -> v.getGroupId() == idGroup)
                .map(s -> new Student(s.getId(), s.getName(), db.getGroupsTable().get(idGroup), s.getStatus()))
                .collect(Collectors.toList());
    }
}
