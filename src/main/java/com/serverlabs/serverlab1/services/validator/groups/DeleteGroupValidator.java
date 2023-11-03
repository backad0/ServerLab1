package com.serverlabs.serverlab1.services.validator.groups;


import com.serverlabs.serverlab1.requests.groups.DeleteGroupRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class DeleteGroupValidator implements IValidator<DeleteGroupRequest> {
    private ValidatorId idV;

    @Override
    public List<String> validator(DeleteGroupRequest request){
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getId(), errors, "id");

        return errors;
    }
}
