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
import com.yychat.model.User;
public class yychatServer {
    ServerSocket serverSocket;;
    Socket socket;

    public yychatServer(){
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Port-5000 running");
            socket = serverSocket.accept();
            System.out.println("Successfully Connected:"+socket);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();

            String username = user.getUsername();
            String password = user.getPassword();

            System.out.println("Server Received:\n"+"Username:"+username+"\n"+"Password:"+password);


        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


}
