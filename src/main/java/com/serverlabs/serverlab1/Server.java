package com.serverlabs.serverlab1;

import com.serverlabs.serverlab1.controller.GroupController;
import com.serverlabs.serverlab1.controller.StudentController;
import com.serverlabs.serverlab1.database.Database;
import com.serverlabs.serverlab1.database.repositories.GroupRepo;
import com.serverlabs.serverlab1.database.repositories.StudentRepo;
import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.excepcions.ServerException;
import com.serverlabs.serverlab1.handler.IHandler;
import com.serverlabs.serverlab1.handler.handlers.group.AddGroupHandler;
import com.serverlabs.serverlab1.handler.handlers.group.DeleteGroupHandler;
import com.serverlabs.serverlab1.handler.handlers.group.EditGroupHandler;
import com.serverlabs.serverlab1.handler.handlers.group.GetGroupByIdHandler;
import com.serverlabs.serverlab1.handler.handlers.student.*;
import com.serverlabs.serverlab1.services.GroupService;
import com.serverlabs.serverlab1.services.StudentService;
import com.serverlabs.serverlab1.services.validator.groups.AddGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.DeleteGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.EditGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.GetGroupByIdValidator;
import com.serverlabs.serverlab1.services.validator.student.*;

import java.util.HashMap;
import java.util.Map;

public class Server implements IServer {
    private static Map<String, IHandler> handler;

    private static StudentController studentController;
    private static GroupController groupController;

    static {
        Database database = new Database(new HashMap<>(), new HashMap<>());
        StudentService studentService = new StudentService(new StudentRepo(database));
        GroupService groupService = new GroupService(new GroupRepo(database));
        studentController = new StudentController(studentService, new AddStudentValidator(), new DeleteStudentValidator(),
                new EditStudentValidator(), new GetStudentsByGroupValidator(), new GetStudentByIdValidator());
        groupController = new GroupController(groupService, new AddGroupValidator(), new DeleteGroupValidator(),
                new EditGroupValidator(), new GetGroupByIdValidator());
        handler = new HashMap<>();
        handler.put("add student", new AddStudentHandler(studentController));
        handler.put("delete student", new DeleteStudentHandler(studentController));
        handler.put("edit student", new EditStudentHandler(studentController));
        handler.put("get student by id", new GetStudentByIdHandler(studentController));
        handler.put("get students by group", new GetStudentByGroupHandler(studentController));
        handler.put("add group", new AddGroupHandler(groupController));
        handler.put("delete group", new DeleteGroupHandler(groupController));
        handler.put("edit group", new EditGroupHandler(groupController));
        handler.put("get group by id", new GetGroupByIdHandler(groupController));
    }


    public Server() {}

    @Override
    public String executeRequest(String json, String endPoint) throws ServerException {
        if (!handler.containsKey(endPoint))
            throw new ServerException("No such endpoint");
        try {
            return handler.get(endPoint).handle(json);
        } catch (Exception e){
            throw new ServerException(e.getMessage());
        }
    }
}
