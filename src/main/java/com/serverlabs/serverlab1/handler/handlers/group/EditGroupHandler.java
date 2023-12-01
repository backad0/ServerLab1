package com.serverlabs.serverlab1.handler.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverlabs.serverlab1.controller.GroupController;
import com.serverlabs.serverlab1.excepcions.HandleException;
import com.serverlabs.serverlab1.handler.IHandler;
import com.serverlabs.serverlab1.requests.groups.EditGroupRequest;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;

public class EditGroupHandler implements IHandler {

    private GroupController controller;

    public EditGroupHandler(GroupController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseEntity<CommonResponse<Void>> res = controller.
                    editGroup(mapper.readValue(json, EditGroupRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandleException(e.getMessage());
        }
    }
}
