package com.yychat.control;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:14:44
 * File:ServerReceiverThread.java
 * Software:IntelliJ IDEA
 */
import java.io.*;
import java.net.*;
import java.util.*;

import com.yychat.model.*;
/**
 * @author SEMHAQ
 */
public class ServerReceiverThread extends Thread{
    Socket socket;

    public ServerReceiverThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        while (true){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();

                if (message.getMessageType().equals(MessageType.CHAT_MESSAGE)){
                    System.out.println(message.getSender() + " 对 " + message.getReceiver() + " 说 " + message.getContent());

                    String receiver = message.getReceiver();
                    Socket receiverSocket = yychatServer.hashMap.get(receiver);
                    System.out.println("Receiver "+ receiver + " 的Socket对象 " + receiverSocket);

                    if (receiverSocket != null){
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(receiverSocket.getOutputStream());
                        objectOutputStream.writeObject(message);
                    }else {
                        System.out.println(receiver + "不在线上");
                    }
                }


                if (message.getMessageType().equals(MessageType.REQUEST_ONLINE_FRIEND)){
                    Set onlineFriendSet = yychatServer.hashMap.keySet();
                    Iterator it = onlineFriendSet.iterator();
                    String onlineFriend = "";

                    while (it.hasNext()){
                        onlineFriend = " " + (String) it.next() + onlineFriend;
                    }

                    message.setReceiver(message.getSender());
                    message.setSender("Server");
                    message.setMessageType(MessageType.RESPONSE_ONLINE_FRIEND);
                    message.setContent(onlineFriend);
                    sendMessage(socket,message);

                }


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }


    public void sendMessage(Socket socket,Message message){
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
