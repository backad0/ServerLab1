package com.serverlabs.serverlab1.services;


import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;
import com.serverlabs.serverlab1.excepcions.ServerException;
import com.serverlabs.serverlab1.responses.students.AddStudentResponse;

import java.util.List;

public interface IStudentService {
    long addStudent(String name, long groupId, StudentStatus status) throws ServerException;

    void editStudent(StudentDB student) throws ServerException;

    void deleteStudent(long id) throws ServerException;

    StudentDB getStudent(long id) throws ServerException;

    List<Student> getStudentsByGroup(long groupId) throws ServerException;
}
