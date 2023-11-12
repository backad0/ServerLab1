package com.serverlabs.serverlab1.services;

import com.serverlabs.serverlab1.database.repositories.GroupRepo;
import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.excepcions.ServerException;

public class GroupService implements IGroupService{
    private GroupRepo repo;

    public GroupService(GroupRepo repo) {
        this.repo = repo;
    }

    @Override
    public long addGroup(String name) throws ServerException {
        try {
            return repo.addGroup(name);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @Override
    public void deleteGroup(long id) throws ServerException {
        try {
            repo.deleteGroup(id);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @Override
    public void editGroup(Group group) throws ServerException {
        try {
            repo.editGroup(group);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @Override
    public Group getGroup(long id) throws ServerException {
        try {
            return repo.getGroupById(id);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }
}
