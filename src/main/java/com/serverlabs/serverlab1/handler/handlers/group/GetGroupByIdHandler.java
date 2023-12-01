package com.serverlabs.serverlab1.handler.handlers.group;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverlabs.serverlab1.controller.GroupController;
import com.serverlabs.serverlab1.excepcions.HandleException;
import com.serverlabs.serverlab1.handler.IHandler;
import com.serverlabs.serverlab1.requests.groups.GetGroupByIdRequest;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.groups.GetGroupByIdResponse;

public class GetGroupByIdHandler implements IHandler {

    private GroupController controller;

    public GetGroupByIdHandler(GroupController controller) {
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws HandleException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ResponseEntity<CommonResponse<GetGroupByIdResponse>> res = controller.
                    getGroupById(mapper.readValue(json, GetGroupByIdRequest.class));
            return mapper.writeValueAsString(res);
        } catch (Exception e) {
            throw new HandleException(e.getMessage());
        }
    }
}
