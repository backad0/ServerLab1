package com.serverlabs.serverlab1.controller;

import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;
import com.serverlabs.serverlab1.requests.students.*;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.students.AddStudentResponse;
import com.serverlabs.serverlab1.responses.students.GetStudentByIdResponse;
import com.serverlabs.serverlab1.services.IStudentService;
import com.serverlabs.serverlab1.services.validator.student.*;

import java.util.List;

public class StudentController {
    private final IStudentService studentService;
    private final AddStudentValidator addStudentValidator;
    private final DeleteStudentValidator deleteStudentValidator;
    private final EditStudentValidator editStudentValidator;
    private final GetStudentsByGroupValidator getStudentsByGroupValidator;
    private final GetStudentByIdValidator getStudentByIdValidator;

    public StudentController(IStudentService studentService, AddStudentValidator addStudentValidator, DeleteStudentValidator deleteStudentValidator,
                             EditStudentValidator editStudentValidator, GetStudentsByGroupValidator getStudentsByGroupValidator,
                             GetStudentByIdValidator getStudentByIdValidator) {
        this.studentService = studentService;
        this.addStudentValidator = addStudentValidator;
        this.deleteStudentValidator = deleteStudentValidator;
        this.editStudentValidator = editStudentValidator;
        this.getStudentsByGroupValidator = getStudentsByGroupValidator;
        this.getStudentByIdValidator = getStudentByIdValidator;
    }

    public ResponseEntity<CommonResponse<AddStudentResponse>> addStudent(AddStudentRequest request) {
        int status = 201;
        CommonResponse<AddStudentResponse> commonResponse;
        List<String> errors = addStudentValidator.validator(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(
                        new AddStudentResponse(studentService.addStudent(request.getName(), request.getIdGroup(), request.getStatus())));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<Void>> deleteStudent(DeleteStudentRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = deleteStudentValidator.validator(request);
        if (errors.isEmpty()) {
            try {
                studentService.deleteStudent(request.getId());
                commonResponse = new CommonResponse<>(null);
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<Void>> editStudent(EditStudentRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = editStudentValidator.validator(request);
        if (errors.isEmpty()) {
            try {
                studentService.editStudent(request.getStudent());
                commonResponse = new CommonResponse<>(null);
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<List<Student>>> getStudentsByGroup(GetStudentsByGroupRequest request) {
        int status = 200;
        CommonResponse<List<Student>> commonResponse;
        List<String> errors = getStudentsByGroupValidator.validator(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(studentService.getStudentsByGroup(request.getId()));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<GetStudentByIdResponse>> getStudentById(GetStudentByIdRequest request) {
        int status = 200;
        CommonResponse<GetStudentByIdResponse> commonResponse;
        List<String> errors = getStudentByIdValidator.validator(request);
        if (errors.isEmpty()) {
            try {
                commonResponse = new CommonResponse<>(new GetStudentByIdResponse(studentService.getStudent(request.getId())));
            } catch (Exception e) {
                status = 500;
                commonResponse = new CommonResponse<>(1, e.getMessage());
            }
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }
}
