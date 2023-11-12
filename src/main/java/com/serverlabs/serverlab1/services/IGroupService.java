package com.serverlabs.serverlab1.services;

import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.excepcions.ServerException;

public interface IGroupService {
    long addGroup(String name) throws ServerException;

    void deleteGroup(long id) throws ServerException ;

    void editGroup(Group group) throws ServerException ;

    Group getGroup(long id) throws ServerException ;
}
