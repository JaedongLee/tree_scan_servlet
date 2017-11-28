package com.scan;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DB {
    public static Connection connectMysql() throws ClassNotFoundException, SQLException {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "tree_scan";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        String user = "root";
        String password = "3276588ztr";
        Class.forName(driver);
        con = DriverManager.getConnection(url,user,password);
        if (con.isClosed()) {
            System.out.println("failed connecting to the Datebase" + dbName);
            return null;

        }else {
            System.out.println("Succeed connecting to the Datebase" + dbName);
            return con;
        }

    }
    public Map<String, String > getSingleData(String table, String table_id) throws ClassNotFoundException, SQLException {
        Connection con = connectMysql();
        Statement statement = con.createStatement();
        String query = "select * from " + table + " where id = " + table_id;
        ResultSet rs = statement.executeQuery(query);
        String id = null;
        String name = null;
        String category = null;
        String picture_url = null;
        String appearance = null;
        String habit = null;
        String distribution = null;
        String point = null;
        String provider_class = null;
        String provider_name = null;
        if (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("name");
            category = rs.getString("category");
            picture_url = rs.getString("picture_url");
            appearance = rs.getString("appearance");
            habit = rs.getString("habit");
            distribution = rs.getString("distribution");
            point = rs.getString("point");
            provider_class = rs.getString("provider_class");
            provider_name = rs.getString("provider_name");
        }
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("category",category);
        map.put("picture_url",picture_url);
        map.put("appearance",appearance);
        map.put("habit",habit);
        map.put("distribution",distribution);
        map.put("point",point);
        map.put("provider_class",provider_class);
        map.put("provider_name",provider_name);
        rs.close();
        return map;
    }
}
