package com.yychat.control;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月06日
 * Time:11:28
 * File:DBUtils.java
 * Software:IntelliJ IDEA
 */
import com.yychat.model.Message;

import java.sql.*;
import java.util.Date;

public class DBUtils {
    public static String dbUrl = "jdbc:mysql://127.0.0.1:3306/yychat";
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

    public static boolean seekUser(String userName){
        boolean seekSuccess=false;
        Connection conn = getConnection();
        String seekUserSql ="select * from user where username=?";
        PreparedStatement ptmt;
        try {
            ptmt = conn.prepareStatement(seekUserSql);
            ptmt.setString(1,userName);
            ResultSet rs = ptmt.executeQuery();
            seekSuccess=rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seekSuccess;
    }

    public static void insertIntoUser(String userName,String password){
        String insertIntoUserSql ="insert into user(username,password) values(?,?)";
        PreparedStatement ptmt;
        try {
            ptmt = connection.prepareStatement(insertIntoUserSql);
            ptmt.setString(1,userName);
            ptmt.setString(2, password);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String seekAllFriend(String userName, int friendType){
        StringBuilder allFriend= new StringBuilder();

        String seekAllFriend ="select slaveuser from user_relationship where masteruser=? and relation=?";
        PreparedStatement ptmt;
        try {
            ptmt = connection.prepareStatement(seekAllFriend);
            ptmt.setString(1,userName);
            ptmt.setInt(2,friendType);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()) {
                allFriend.append(" ").append(rs.getString(1));
            }
            System.out.println(allFriend);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allFriend.toString();
    }

    public static boolean seekFriend(String sender,String newFriend,int friendType){
        boolean seekSuccess = false;
        String str = "select * from user_relationship where masteruser=? and slaveuser=? and relation=?";
        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(str);
            preparedStatement.setString(1,sender);
            preparedStatement.setString(2,newFriend);
            preparedStatement.setInt(3,friendType);
            ResultSet resultSet = preparedStatement.executeQuery();
            seekSuccess = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seekSuccess;
    }

    public static void insertIntoFriend(String masterUser,String slaveUser,int relationType){
        String str ="insert into user_relationship (masteruser,slaveuser,relation) values(?,?,?)";
        PreparedStatement ptmt;
        try {
            ptmt = connection.prepareStatement(str);
            ptmt.setString(1,masterUser);
            ptmt.setString(2,slaveUser);
            ptmt.setInt(3,relationType);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveMessage(Message message){
        String str = "insert into message(sender,receiver,content,sendtime) values(?,?,?,?)";
        PreparedStatement prompt;
        try {
            prompt = connection.prepareStatement(str);
            prompt.setString(1,message.getSender());
            prompt.setString(2,message.getReceiver());
            prompt.setString(3,message.getContent());
            Date date = message.getSendTime();
            prompt.setTimestamp(4,new Timestamp(date.getTime()));
            prompt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
