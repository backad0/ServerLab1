package com.serverlabs.serverlab1.services.validator.student;

import com.serverlabs.serverlab1.requests.students.AddStudentRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorString;

import java.util.ArrayList;
import java.util.List;

public class AddStudentValidator implements IValidator<AddStudentRequest> {
    private ValidatorString stringV;
    private ValidatorId idV;

    public AddStudentValidator() {
        stringV = new ValidatorString();
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(AddStudentRequest request) {
        List<String> errors = new ArrayList<>();

        stringV.isNotNull(request.getName(), errors, "name");
        stringV.isNotEmpty(request.getName(), errors, "name");
        stringV.isNotOverflow(request.getName(), errors, "name", 255);

        idV.isNotNegative(request.getIdGroup(), errors, "idGroup");

        return errors;
    }
}
