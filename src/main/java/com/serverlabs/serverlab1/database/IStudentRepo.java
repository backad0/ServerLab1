package com.serverlabs.serverlab1.database;


import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.excepcions.RepositoryException;

import java.util.List;

public interface IStudentRepo {
    long addStudent(StudentDB student) throws RepositoryException;

    void deleteStudent(long idStudent) throws RepositoryException;

    void editStudent(StudentDB student) throws RepositoryException;

    StudentDB getStudentById(long id) throws RepositoryException;

    List<Student> getStudentByIdGroup(long idGroup) throws RepositoryException;
}
