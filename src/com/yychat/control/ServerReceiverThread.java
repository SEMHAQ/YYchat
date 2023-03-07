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

                if (message.getMessageType().equals(MessageType.ADD_NEW_FRIEND)){
                    String sender = message.getSender();
                    String newFriend = message.getContent();

                    if (DBUtils.seekUser(newFriend)){

                        if (DBUtils.seekFriend(sender,newFriend,1)){
                            message.setMessageType(MessageType.ADD_NEW_FRIEND_FAILURE_ALREADY_FRIEND);
                        }else {
                            DBUtils.insertIntoFriend(sender,newFriend,1);

                            String allFriend = DBUtils.seekAllFriend(sender,1);

                            message.setContent(allFriend);
                            message.setMessageType(MessageType.ADD_NEW_FRIEND_SUCCESS);

                        }

                    }else {
                        message.setMessageType(MessageType.ADD_NEW_FRIEND_FAILURE_NO_USER);
                    }

                    Socket socket = (Socket) yychatServer.hashMap.get(sender);
                    sendMessage(socket,message);

                }

                if (message.getMessageType().equals(MessageType.CHAT_MESSAGE)){
                    System.out.println(message.getSender() + " 对 " + message.getReceiver() + " 说 " + message.getContent());

                    message.setSendTime(new Date());
                    DBUtils.saveMessage(message);

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

                if (message.getMessageType().equals(MessageType.NEW_ONLINE_TO_ALLFRIEND)){
                    message.setMessageType(MessageType.NEW_ONLINE_FRIEND);
                    Set onlineFriendSet = yychatServer.hashMap.keySet();
                    Iterator it = onlineFriendSet.iterator();
                    while (it.hasNext()){
                        String receiver = (String) it.next();
                        message.setReceiver(receiver);

                        Socket socket = (Socket) yychatServer.hashMap.get(receiver);
                        sendMessage(socket,message);
                    }
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
