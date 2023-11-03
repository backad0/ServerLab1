package com.serverlabs.serverlab1.controller;

import com.serverlabs.serverlab1.requests.groups.AddGroupRequest;
import com.serverlabs.serverlab1.requests.groups.DeleteGroupRequest;
import com.serverlabs.serverlab1.requests.groups.EditGroupRequest;
import com.serverlabs.serverlab1.requests.groups.GetGroupByIdRequest;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.groups.AddGroupResponse;
import com.serverlabs.serverlab1.responses.groups.GetGroupByIdResponse;
import com.serverlabs.serverlab1.services.validator.groups.AddGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.DeleteGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.EditGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.GetGroupByIdValidator;


import java.util.List;

public class GroupController {
    private AddGroupValidator addGroupValidator;
    private DeleteGroupValidator deleteGroupValidator;
    private EditGroupValidator editGroupValidator;
    private GetGroupByIdValidator getGroupByIdValidator;

    public ResponseEntity<CommonResponse<AddGroupResponse>> addGroup(AddGroupRequest request) {
        int status = 201;
        CommonResponse<AddGroupResponse> commonResponse;
        List<String> errors = addGroupValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(new AddGroupResponse("name"));
        } else {
            commonResponse = new CommonResponse<>(0, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<Void>> deleteGroup(DeleteGroupRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = deleteGroupValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(null);
        } else {
            commonResponse = new CommonResponse<>(1, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<Void>> editGroup(EditGroupRequest request) {
        int status = 200;
        CommonResponse<Void> commonResponse;
        List<String> errors = editGroupValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(null);
        } else {
            commonResponse = new CommonResponse<>(2, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }

    public ResponseEntity<CommonResponse<GetGroupByIdResponse>> getGroupById(GetGroupByIdRequest request) {
        int status = 200;
        CommonResponse<GetGroupByIdResponse> commonResponse;
        List<String> errors = getGroupByIdValidator.validator(request);
        if (errors.isEmpty()) {
            commonResponse = new CommonResponse<>(new GetGroupByIdResponse(10l, "name"));
        } else {
            commonResponse = new CommonResponse<>(3, "Validation error", errors);
            status = 422;
        }
        return new ResponseEntity<>(commonResponse, status);
    }
}
