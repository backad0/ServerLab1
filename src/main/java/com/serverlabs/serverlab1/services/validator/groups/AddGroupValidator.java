package com.serverlabs.serverlab1.services.validator.groups;


import com.serverlabs.serverlab1.requests.groups.AddGroupRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorString;

import java.util.ArrayList;
import java.util.List;

public class AddGroupValidator implements IValidator<AddGroupRequest> {
    private ValidatorString stringV;
    private ValidatorId idV;

    public AddGroupValidator() {
        stringV = new ValidatorString();
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(AddGroupRequest request){
        List<String> errors = new ArrayList<>();

        stringV.isNotNull(request.getName(), errors, "groupName");
        stringV.isNotEmpty(request.getName(), errors, "groupName");
        stringV.isNotOverflow(request.getName(), errors, "groupName", 255);

        return errors;
    }
}
