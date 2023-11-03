package com.serverlabs.serverlab1.database;


import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.excepcions.RepositoryException;

public interface IGroupRepo {
    long addGroup(Group group) throws RepositoryException;

    void deleteGroup(long id) throws RepositoryException;

    void editGroup(Group group) throws RepositoryException;

    Group getGroupById(long id) throws RepositoryException;
}
