package com.scan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Http extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Map<String, String> map = new HashMap<>();
        String agent = request.getHeader("User-Agent");
        if (null == request.getParameter("agent")) {
            if (!(agent.contains("MicroMessenger")&&agent.contains("iPhone"))) {
                map.put("status", "error");
                map.put("download_url", "/resource/tree_appreciate.apk");
            } else{
                String table_id = request.getParameter("id");
                String table = "tree";
                DB db = new DB();
                try {

                    map = db.getSingleData(table,table_id);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } else {
            String table_id = request.getParameter("id");
            String table = "tree";
            DB db = new DB();
            try {

                map = db.getSingleData(table,table_id);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Response res = new Response();
        res.sendScRespose(map,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }

}
