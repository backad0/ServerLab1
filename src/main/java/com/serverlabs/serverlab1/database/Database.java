package com.serverlabs.serverlab1.database;


import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.entities.StudentDB;

import java.util.Map;

public class Database {
    private Map<Long, StudentDB> studentsTable;
    private Map<Long, Group> groupsTable;

    public Map<Long, StudentDB> getStudentsTable() {
        return studentsTable;
    }

    public Map<Long, Group> getGroupsTable() {
        return groupsTable;
    }

    public Database(Map<Long, StudentDB> studentsTable, Map<Long, Group> groupsTable) {
        this.studentsTable = studentsTable;
        this.groupsTable = groupsTable;
    }
}
