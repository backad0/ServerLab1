package com.serverlabs.serverlab1.handler.handlers.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverlabs.serverlab1.controller.StudentController;
import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.excepcions.HandleException;
import com.serverlabs.serverlab1.handler.IHandler;
import com.serverlabs.serverlab1.requests.students.GetStudentByIdRequest;
import com.serverlabs.serverlab1.requests.students.GetStudentsByGroupRequest;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.students.GetStudentByIdResponse;

import java.util.List;

public class GetStudentByGroupHandler implements IHandler {

    private StudentController controller;

    public GetStudentByGroupHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseEntity<CommonResponse<List<Student>>> res = controller.
                    getStudentsByGroup(mapper.readValue(json, GetStudentsByGroupRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandleException(e.getMessage());
        }
    }
}
