package com.serverlabs.serverlab1.services.validator.primitive;

import java.util.List;

public final class ValidatorString {
    public boolean isNotEmpty(String str, List<String> errors, String fieldName) {
        if (str.isEmpty()) {
            errors.add(fieldName + ": Is empty");
            return false;
        }
        return true;
    }

    public boolean isNotNull(String str, List<String> errors, String fieldName) {
        if (str == null) {
            errors.add(fieldName +": Is null");
            return false;
        }
        return true;
    }

    public boolean isNotOverflow(String str,List<String> errors, String fieldName, int maxLength) {
        int len = str.length();
        if (len > maxLength){
            errors.add(fieldName +": Is overflow");
            return false;
        }
        return true;
    }

}
