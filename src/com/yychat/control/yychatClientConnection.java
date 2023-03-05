package com.yychat.control;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:13:55
 * File:yychatClientConnection.java
 * Software:IntelliJ IDEA
 */

import java.io.*;
import java.net.*;
import com.yychat.model.User;
public class yychatClientConnection {
    Socket socket;

    public yychatClientConnection(){
        try {
            socket = new Socket("127.0.0.1",5000);
            System.out.println("Successfully Connected:" + socket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loginValidate(User user){
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);;
            objectOutputStream.writeObject(user);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
