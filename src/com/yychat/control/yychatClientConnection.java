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

import com.yychat.model.Message;
import com.yychat.model.User;
import com.yychat.model.MessageType;
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

    public boolean loginValidate(User user){
        boolean isLogin = false;
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);;
            objectOutputStream.writeObject(user);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) objectInputStream.readObject();

            if (message.getMessageType().equals(MessageType.LOGIN_SUCCESS)){
                isLogin = true;
            }

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return isLogin;
    }

}
