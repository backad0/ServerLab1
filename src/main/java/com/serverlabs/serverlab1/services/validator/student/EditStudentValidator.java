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

    public EditStudentValidator() {
        stringV = new ValidatorString();
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(EditStudentRequest request) {
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getStudent().getId(), errors, "id");

        stringV.isNotNull(request.getStudent().getName(), errors, "name");
        stringV.isNotEmpty(request.getStudent().getName(), errors, "name");
        stringV.isNotOverflow(request.getStudent().getName(), errors, "name", 255);

        idV.isNotNegative(request.getStudent().getGroupId(), errors, "groupId");

        return errors;
    }
}
