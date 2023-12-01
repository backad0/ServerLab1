package com.serverlabs.serverlab1.handler;

import com.serverlabs.serverlab1.excepcions.HandleException;

public interface IHandler {
    String handle(String endpoint) throws HandleException;
}
