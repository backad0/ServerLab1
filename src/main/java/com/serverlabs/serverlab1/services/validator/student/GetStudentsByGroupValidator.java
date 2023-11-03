package com.serverlabs.serverlab1.services.validator.student;

import com.serverlabs.serverlab1.requests.students.GetStudentsByGroupRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsByGroupValidator implements IValidator<GetStudentsByGroupRequest> {
    private ValidatorId idV;

    @Override
    public List<String> validator(GetStudentsByGroupRequest request){
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getId(), errors, "groupId");

        return errors;
    }

}
