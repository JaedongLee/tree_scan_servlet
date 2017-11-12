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
        String description = null;
        if (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("name");
            description = rs.getString("description");
        }
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("description",description);
        rs.close();
        return map;
    }
}
