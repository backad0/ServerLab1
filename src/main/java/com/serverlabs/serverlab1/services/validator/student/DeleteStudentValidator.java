package com.serverlabs.serverlab1.services.validator.student;

import com.serverlabs.serverlab1.requests.students.DeleteStudentRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentValidator implements IValidator<DeleteStudentRequest> {
    private ValidatorId idV;

    public DeleteStudentValidator() {
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(DeleteStudentRequest request) {
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getId(), errors, "id");

        return errors;
    }
}
