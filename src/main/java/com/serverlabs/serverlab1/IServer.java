package com.serverlabs.serverlab1;

import com.serverlabs.serverlab1.excepcions.ServerException;

public interface IServer {
    String executeRequest(String json, String endPoint) throws ServerException;
}
