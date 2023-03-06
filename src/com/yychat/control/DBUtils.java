package com.yychat.control;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月06日
 * Time:11:28
 * File:DBUtils.java
 * Software:IntelliJ IDEA
 */
import java.sql.*;
public class DBUtils {
    public static String dbUrl = "jdbc:mysql://127.0.0.1:3306/yychat?useUnicode=true&characterEncoding=utf-8";
    public static String dbUsername = "root";
    public static String dbPassword = "SEMHAQ";
    public static Connection connection = getConnection();


    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return connection;

    }



    public static boolean loginValidate(String username,String password){
        boolean isLogin = false;
        String userQuery = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement(userQuery);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            isLogin = resultSet.next();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return isLogin;
    }







}
