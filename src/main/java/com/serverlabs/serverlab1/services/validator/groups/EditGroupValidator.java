package com.serverlabs.serverlab1.services.validator.groups;


import com.serverlabs.serverlab1.requests.groups.EditGroupRequest;
import com.serverlabs.serverlab1.services.validator.IValidator;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorId;
import com.serverlabs.serverlab1.services.validator.primitive.ValidatorString;

import java.util.ArrayList;
import java.util.List;

public class EditGroupValidator implements IValidator<EditGroupRequest> {
    private ValidatorString stringV;
    private ValidatorId idV;

    public EditGroupValidator() {
        stringV = new ValidatorString();
        idV = new ValidatorId();
    }

    @Override
    public List<String> validator(EditGroupRequest request){
        List<String> errors = new ArrayList<>();

        idV.isNotNegative(request.getGroup().getId(), errors, "groupId");

        stringV.isNotNull(request.getGroup().getName(), errors, "groupName");
        stringV.isNotEmpty(request.getGroup().getName(), errors, "groupName");
        stringV.isNotOverflow(request.getGroup().getName(), errors, "groupName", 255);

        return errors;
    }
}
