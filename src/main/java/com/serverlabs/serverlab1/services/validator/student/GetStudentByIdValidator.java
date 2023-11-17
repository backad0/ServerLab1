package com.serverlabs.serverlab1.services.validator.student;


import com.serverlabs.serverlab1.requests.students.GetStudentByIdRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdValidator implements IValidator<GetStudentByIdRequest> {
    private ValidatorId idV;

    public GetStudentByIdValidator() {
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(GetStudentByIdRequest request){
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getId(), errors, "id");

        return errors;
    }
}
