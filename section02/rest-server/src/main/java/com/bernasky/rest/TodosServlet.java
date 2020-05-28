package com.bernasky.rest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.bernasky.rest.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TodosServlet extends HttpServlet {

    private static final Gson GSON = new GsonBuilder().create();
    private Map<Long, Todo> todos = new HashMap<>();

    public TodosServlet() {
        todos.put(1L, new Todo(1L, "first todo"));
        todos.put(2L, new Todo(2L, "second todo"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = GSON.toJson(todos.values());

        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(json);
    }

}