package com.serverlabs.serverlab1.handler.handlers.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverlabs.serverlab1.controller.StudentController;
import com.serverlabs.serverlab1.excepcions.HandleException;
import com.serverlabs.serverlab1.handler.IHandler;
import com.serverlabs.serverlab1.requests.students.AddStudentRequest;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.students.AddStudentResponse;

public class AddStudentHandler implements IHandler {

    private StudentController controller;

    public AddStudentHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseEntity<CommonResponse<AddStudentResponse>> res = controller.
                    addStudent(mapper.readValue(json, AddStudentRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandleException(e.getMessage());
        }
    }
}
