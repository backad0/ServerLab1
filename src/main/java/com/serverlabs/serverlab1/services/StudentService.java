package com.serverlabs.serverlab1.services;

import com.serverlabs.serverlab1.database.repositories.StudentRepo;
import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;
import com.serverlabs.serverlab1.excepcions.ServerException;

import java.util.List;

public class StudentService implements IStudentService{
    private StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    @Override
    public long addStudent(String name, long groupId, StudentStatus status) throws ServerException {
        try {
            return repo.addStudent(name, groupId, status);
        } catch (Exception e){
            throw new ServerException(e.getMessage(), e);
        }
    }

    @Override
    public void editStudent(StudentDB student) throws ServerException {
        try {
            repo.editStudent(student);
        } catch (Exception e) {
            throw new ServerException(e.getMessage(), e);
        }
    }

    @Override
    public void deleteStudent(long id) throws ServerException {
        try {
            repo.deleteStudent(id);
        } catch (Exception e) {
            throw new ServerException(e.getMessage(), e);
        }

    }

    @Override
    public StudentDB getStudent(long id) throws ServerException {
        try {
            return repo.getStudentById(id);
        } catch(Exception e) {
            throw new ServerException(e.getMessage(), e);
        }
    }

    @Override
    public List<Student> getStudentsByGroup(long groupId) throws ServerException {
        try {
            return repo.getStudentByIdGroup(groupId);
        } catch (Exception e) {
            throw new ServerException(e.getMessage(), e);
        }
    }
}
