package com.yychat.control;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:15:42
 * File:ClientReceiverThread.java
 * Software:IntelliJ IDEA
 */
import java.io.*;
import java.net.*;
import com.yychat.model.*;
import com.yychat.view.*;

public class ClientReceiverThread extends Thread{
    Socket socket;

    public ClientReceiverThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        while (true){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                Message message = (Message) objectInputStream.readObject();
                if (message.getMessageType().equals(MessageType.CHAT_MESSAGE)){
                    String receiver = message.getReceiver();
                    String sender = message.getSender();

                    FriendChat friendChat =  FriendList.hashMap.get(receiver+"to"+sender);

                    if (friendChat != null){
                        friendChat.append(message);
                    }else {
                        System.out.println("请打开聊天界面");
                    }

                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
