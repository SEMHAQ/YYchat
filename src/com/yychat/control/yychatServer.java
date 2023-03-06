package com.yychat.control;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:13:45
 * File:yychatServer.java
 * Software:IntelliJ IDEA
 */
import java.io.*;
import java.net.*;
import java.util.*;

import com.yychat.model.MessageType;
import com.yychat.model.User;
import com.yychat.model.Message;

import java.sql.*;

public class yychatServer {
    public static HashMap<String, Socket> hashMap = new HashMap<>();

    ServerSocket serverSocket;;
    Socket socket;

    public yychatServer(){
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Port-5000 running");
            while (true){
                socket = serverSocket.accept();
                System.out.println("Successfully Connected:"+socket);

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();

                String username = user.getUsername();
                String password = user.getPassword();

                System.out.println("Server Received:\n"+"Username:"+username+"\n"+"Password:"+password);


                boolean isLogin = DBUtils.loginValidate(username,password);

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                Message message = new Message();
                if (isLogin){
                    System.out.println("Password Match");
                    message.setMessageType(MessageType.LOGIN_SUCCESS);

                    outputStream.writeObject(message);

                    hashMap.put(username,socket);

                    new ServerReceiverThread(socket).start();
                    System.out.println("Thread Start");

                }else {
                    System.out.println("Password Mismatch");
                    message.setMessageType(MessageType.LOGIN_FAILURE);

                    outputStream.writeObject(message);
                    socket.close();
                }

//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                objectOutputStream.writeObject(message);

            }


        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


}
