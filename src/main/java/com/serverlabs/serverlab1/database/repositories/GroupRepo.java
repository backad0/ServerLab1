package com.serverlabs.serverlab1.database.repositories;


import com.serverlabs.serverlab1.database.Database;
import com.serverlabs.serverlab1.database.IGroupRepo;
import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.excepcions.RepositoryException;

import java.util.Collections;
import java.util.Map;

public class GroupRepo implements IGroupRepo {
    private Database db;
    private long counter;

    public GroupRepo(Database db) {
        this.db = db;
        counter = 0;
    }

    @Override
    public long addGroup(String name) throws RepositoryException {
        Map<Long, Group> groupMap = db.getGroupsTable();
        long key;

        if (groupMap.keySet().isEmpty()){
            key = 0;
        } else {
            key = ++counter;
        } groupMap.put(key, new Group(key, name));
        return key;
    }

    @Override
    public void deleteGroup(long id) throws RepositoryException {
        if (!db.getGroupsTable().keySet().contains(id)) throw new RepositoryException("Not contains exact group");
        db.getGroupsTable().remove(id);
    }

    @Override
    public void editGroup(Group group) throws RepositoryException {
        if (!db.getGroupsTable().keySet().contains(group.getId())) throw new RepositoryException("Not contains exact group");
        db.getGroupsTable().replace(group.getId(), group);
    }

    @Override
    public Group getGroupById(long id) throws RepositoryException {
        if (!db.getGroupsTable().keySet().contains(id)) throw new RepositoryException("Not contains exact group");
        return db.getGroupsTable().get(id);
    }
}
