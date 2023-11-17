package com.serverlabs.serverlab1.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.serverlabs.serverlab1.MainTest;
import com.serverlabs.serverlab1.entities.Student;
import com.serverlabs.serverlab1.entities.StudentDB;
import com.serverlabs.serverlab1.entities.StudentStatus;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class StudentControllerTest extends MainTest {


    List<StudentDB> list = new ArrayList<>(){{
        add(new StudentDB(1L, "n", 1L, StudentStatus.ACTIVE));
    }};

    @Test
    public void addStudentTest1() throws ServerException, JsonParseException {
        String json1;
        String json2;
        try {
            json1 = new JSONObject().put("name", "student3_1").put("idGroup", 1L)
                    .put("status", StudentStatus.ACTIVE).toString();

            json2 = new JSONObject().put("id", 4L).toString();
        } catch (Exception e) {
            throw new JsonParseException(e.getMessage());
        }
        try {
            assertEquals(201, new JSONObject(server.executeRequest(json1, "add student")).get("httpStatus"));
            server.executeRequest(json2, "delete student");
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    @Test
    public void deleteStudentTest1() throws ServerException, JsonParseException {
        String json1;
        String json2;
        try {
            json1 = new JSONObject().put("id", 3L).toString();
            json2 = new JSONObject().put("name", "student3_1").put("idGroup", 1L)
                    .put("status", StudentStatus.ACTIVE).toString();
        } catch (Exception e) {
            throw new JsonParseException(e.getMessage());
        }
        try {
            server.executeRequest(json2, "add student");
            assertNull(server.executeRequest(json1, "delete student"));
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

}
