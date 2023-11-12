package com.serverlabs.serverlab1.database.repositories;


import com.serverlabs.serverlab1.database.Database;
import com.serverlabs.serverlab1.database.IGroupRepo;
import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.excepcions.RepositoryException;

import java.util.Collections;
import java.util.Map;

public class GroupRepo implements IGroupRepo {
    private Database db;

    public GroupRepo(Database db) {
        this.db = db;
    }

    @Override
    public long addGroup(String name) throws RepositoryException {
        Map<Long, Group> groupMap = db.getGroupsTable();
        long key;
        if (groupMap.keySet().isEmpty()){
            key = 0;
        } else {
            key = Collections.max(groupMap.keySet()) + 1;
        } groupMap.put(key, new Group(key, name));
        return key;
    }

    @Override
    public void deleteGroup(long id) throws RepositoryException {
        if (!db.getGroupsTable().keySet().contains(id)) return;
        db.getGroupsTable().remove(id);
    }

    @Override
    public void editGroup(Group group) throws RepositoryException {
        db.getGroupsTable().replace(group.getId(), group);
    }

    @Override
    public Group getGroupById(long id) throws RepositoryException {
        return db.getGroupsTable().get(id);
    }
}
