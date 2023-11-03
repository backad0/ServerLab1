package com.serverlabs.serverlab1.services.validator.student;


import com.serverlabs.serverlab1.requests.students.EditStudentRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorString;

import java.util.ArrayList;
import java.util.List;

public class EditStudentValidator implements IValidator<EditStudentRequest> {
    private ValidatorString stringV;
    private ValidatorId idV;

    @Override
    public List<String> validator(EditStudentRequest request){
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getId(), errors, "id");

        stringV.isNotNull(request.getName(), errors, "name");
        stringV.isNotEmpty(request.getName(), errors, "name");
        stringV.isNotOverflow(request.getName(), errors, "name", 255);

        idV.isNotNegative(request.getIdGroup(), errors, "groupId");

        stringV.isNotNull(request.getStatus(), errors, "status");
        stringV.isNotEmpty(request.getStatus(), errors, "status");
        stringV.isNotOverflow(request.getStatus(), errors, "status", 255);

        return errors;
    }
}