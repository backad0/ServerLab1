package com.serverlabs.serverlab1.services.validator.primitive;

import java.util.List;

public class ValidatorId {
    public boolean isNotNegative(Long id, List<String> errors, String fieldName){
        if (id < 0){
            errors.add(fieldName+": Is negative");
            return false;
        }
        return true;
    }
}
