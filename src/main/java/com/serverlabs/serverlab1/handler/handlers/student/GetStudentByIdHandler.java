package com.serverlabs.serverlab1.handler.handlers.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverlabs.serverlab1.controller.StudentController;
import com.serverlabs.serverlab1.excepcions.HandleException;
import com.serverlabs.serverlab1.handler.IHandler;
import com.serverlabs.serverlab1.requests.students.GetStudentByIdRequest;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.students.GetStudentByIdResponse;

public class GetStudentByIdHandler implements IHandler {

    private StudentController controller;

    public GetStudentByIdHandler(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseEntity<CommonResponse<GetStudentByIdResponse>> res = controller.
                    getStudentById(mapper.readValue(json, GetStudentByIdRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandleException(e.getMessage());
        }
    }
}
