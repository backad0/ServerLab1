package com.serverlabs.serverlab1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverlabs.serverlab1.controller.GroupController;
import com.serverlabs.serverlab1.controller.StudentController;
import com.serverlabs.serverlab1.database.Database;
import com.serverlabs.serverlab1.database.repositories.GroupRepo;
import com.serverlabs.serverlab1.database.repositories.StudentRepo;
import com.serverlabs.serverlab1.entities.Group;
import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.excepcions.ServerException;
import com.serverlabs.serverlab1.requests.groups.AddGroupRequest;
import com.serverlabs.serverlab1.requests.groups.DeleteGroupRequest;
import com.serverlabs.serverlab1.requests.groups.EditGroupRequest;
import com.serverlabs.serverlab1.requests.groups.GetGroupByIdRequest;
import com.serverlabs.serverlab1.requests.students.*;
import com.serverlabs.serverlab1.responses.CommonResponse;
import com.serverlabs.serverlab1.responses.ResponseEntity;
import com.serverlabs.serverlab1.responses.groups.AddGroupResponse;
import com.serverlabs.serverlab1.responses.groups.GetGroupByIdResponse;
import com.serverlabs.serverlab1.responses.students.AddStudentResponse;
import com.serverlabs.serverlab1.responses.students.GetStudentByIdResponse;
import com.serverlabs.serverlab1.services.GroupService;
import com.serverlabs.serverlab1.services.StudentService;
import com.serverlabs.serverlab1.services.validator.groups.AddGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.DeleteGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.EditGroupValidator;
import com.serverlabs.serverlab1.services.validator.groups.GetGroupByIdValidator;
import com.serverlabs.serverlab1.services.validator.student.*;

import java.util.HashMap;
import java.util.List;

public class Server implements IServer {
    private StudentController studentController;
    private GroupController groupController;

    private final Database database;
    private final StudentService studentService;
    private final GroupService groupService;


    public Server() {
        database = new Database(new HashMap<Long, StudentDB>(), new HashMap<Long, Group>());
        studentService = new StudentService(new StudentRepo(database));
        groupService = new GroupService(new GroupRepo(database));
        studentController = new StudentController(studentService, new AddStudentValidator(), new DeleteStudentValidator(),
                new EditStudentValidator(), new GetStudentsByGroupValidator(), new GetStudentByIdValidator());
        groupController = new GroupController(groupService, new AddGroupValidator(), new DeleteGroupValidator(),
                new EditGroupValidator(), new GetGroupByIdValidator());
    }

    @Override
    public String executeRequest(String json, String endPoint) throws ServerException {
        ObjectMapper mapper = new ObjectMapper();
        switch (endPoint) {
            case ("add student"):
                try {
                    ResponseEntity<CommonResponse<AddStudentResponse>> res = studentController.
                            addStudent(mapper.readValue(json, AddStudentRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("delete student"):
                try {
                    ResponseEntity<CommonResponse<Void>> res = studentController.
                            deleteStudent(mapper.readValue(json, DeleteStudentRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("edit student"):
                try {
                    ResponseEntity<CommonResponse<Void>> res = studentController.
                            editStudent(mapper.readValue(json, EditStudentRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("get student by id"):
                try {
                    ResponseEntity<CommonResponse<GetStudentByIdResponse>> res = studentController.
                            getStudentById(mapper.readValue(json, GetStudentByIdRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("get students by group"):
                try {
                    ResponseEntity<CommonResponse<List<Student>>> res = studentController.
                            getStudentsByGroup(mapper.readValue(json, GetStudentsByGroupRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("add group"):
                try {
                    ResponseEntity<CommonResponse<AddGroupResponse>> res = groupController.
                            addGroup(mapper.readValue(json, AddGroupRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("delete group"):
                try {
                    ResponseEntity<CommonResponse<Void>> res = groupController.
                            deleteGroup(mapper.readValue(json, DeleteGroupRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("edit group"):
                try {
                    ResponseEntity<CommonResponse<Void>> res = groupController.
                            editGroup(mapper.readValue(json, EditGroupRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            case ("get group by id"):
                try {
                    ResponseEntity<CommonResponse<GetGroupByIdResponse>> res = groupController.
                            getGroupById(mapper.readValue(json, GetGroupByIdRequest.class));
                    return mapper.writeValueAsString(res);
                } catch (Exception e) {
                    throw new ServerException(e.getMessage());
                }
            default:
                throw new ServerException("No such endpoint");
        }
    }
}
