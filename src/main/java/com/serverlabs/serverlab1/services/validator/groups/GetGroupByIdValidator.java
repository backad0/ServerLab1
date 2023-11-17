package com.serverlabs.serverlab1.services.validator.groups;


import com.serverlabs.serverlab1.requests.groups.GetGroupByIdRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;

import java.util.ArrayList;
import java.util.List;

public class GetGroupByIdValidator implements IValidator<GetGroupByIdRequest> {
    private ValidatorId idV;

    public GetGroupByIdValidator() {
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(GetGroupByIdRequest request){
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getId(), errors, "groupId");

        return errors;
    }
}
