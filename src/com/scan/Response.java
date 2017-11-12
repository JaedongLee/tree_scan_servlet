package com.scan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response {
    final static Gson m_gson = new GsonBuilder().setPrettyPrinting().create();

    public void sendScRespose(Object obj, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/javascript;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (obj != null) {
            String resStr = m_gson.toJson(obj);
            response.getWriter().write(resStr);
        }
    }

}
