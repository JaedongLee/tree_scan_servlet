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
        String alias = null;
        String latin_name = null;
        String category = null;
        String appearance = null;
        String habit = null;
        String distribution = null;
        String point = null;
        String temperature = null;
        String humidity = null;
        String water = null;
        String manure = null;
        String group = null;
        String provider_class = null;
        String provider_name = null;
        String time = null;
        if (rs.next()) {
            id = rs.getString("id");
            name = rs.getString("name");
            alias = rs.getString("alias");
            latin_name = rs.getString("latin_name");
            category = rs.getString("category");
            appearance = rs.getString("appearance");
            habit = rs.getString("habit");
            distribution = rs.getString("distribution");
            point = rs.getString("point");
            temperature = rs.getString("temperature");
            humidity = rs.getString("humidity");
            water = rs.getString("water");
            manure = rs.getString("manure");
            group = rs.getString("group");
            provider_class = rs.getString("provider_class");
            provider_name = rs.getString("provider_name");
            time = rs.getString("time");
        }
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("alias",alias);
        map.put("latin_name",latin_name);
        map.put("category",category);
        map.put("appearance",appearance);
        map.put("habit",habit);
        map.put("distribution",distribution);
        map.put("point",point);
        map.put("temperature",temperature);
        map.put("humidity",humidity);
        map.put("water",water);
        map.put("manure",manure);
        map.put("group",group);
        map.put("provider_class",provider_class);
        map.put("provider_name",provider_name);
        map.put("time",time);
        map.put("status","right");
        rs.close();
        return map;
    }
}
