package com.serverlabs.serverlab1.controller;

import com.serverlabs.serverlab1.entities.StudentStatus;
import com.serverlabs.serverlab1.requests.students.*;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.students.AddStudentResponse;
import com.serverlabs.serverlab1.responses.students.GetStudentByIdResponse;
import com.serverlabs.serverlab1.services.validator.student.*;

import java.util.List;

public class StudentController {
    private AddStudentValidator addStudentValidator;
    private DeleteStudentValidator deleteStudentValidator;
    private EditStudentValidator editStudentValidator;
    private GetStudentsByGroupValidator getStudentsByGroupValidator;
    private GetStudentByIdValidator getStudentByIdValidator;

    public ResponseEntity<CommonResponse<AddStudentResponse>> addStudent(AddStudentRequest request) {
        int status = 201;
        CommonResponse<AddStudentResponse> commonResponse;
        List<String> errors = addStudentValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(new AddStudentResponse(10L));
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
            commonResponse = new CommonResponse<>(null);
        } else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<Void>> editStudent(EditStudentRequest request){
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = editStudentValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(null);
        } else {
            commonResponse = new CommonResponse<>(2, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<Void>> getStudentsByGroup(GetStudentsByGroupRequest request){
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = getStudentsByGroupValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(null);
        } else {
            commonResponse = new CommonResponse<>(3, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<GetStudentByIdResponse>> getStudentById(GetStudentByIdRequest request){
        int status = 200;
        CommonResponse<GetStudentByIdResponse> commonResponse;
        List<String> errors = getStudentByIdValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(new GetStudentByIdResponse(10L,"name", 1L, StudentStatus.ACTIVE));
        } else {
            commonResponse = new CommonResponse<>(4, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }
}
