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

import javax.swing.*;

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

                if (message.getMessageType().equals(MessageType.USER_EXIT_CLIENT_THREAD_CLOSE)){
                    System.out.println("关闭"+ message.getSender()+"用户接收线程");
                    socket.close();
                    break;
                }

                if (message.getMessageType().equals(MessageType.ADD_NEW_FRIEND_FAILURE_NO_USER)){
                    JOptionPane.showMessageDialog(null,"名字不存在");
                }

                if (message.getMessageType().equals(MessageType.ADD_NEW_FRIEND_FAILURE_ALREADY_FRIEND)){
                    JOptionPane.showMessageDialog(null,"已是好友");
                }

                if (message.getMessageType().equals(MessageType.ADD_NEW_FRIEND_SUCCESS)){
                    JOptionPane.showMessageDialog(null,"添加成功");
                    String sender = message.getSender();
                    FriendList friendList = (FriendList) ClientLogin.hashMap.get(sender);

                    String allFriend = message.getContent();
                    friendList.showAllfriend(allFriend);
                }


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


                if (message.getMessageType().equals(MessageType.RESPONSE_ONLINE_FRIEND)){
                    FriendList friendList = ClientLogin.hashMap.get(message.getReceiver());
                    friendList.activeOnlineFriendIcon(message);
                }

                if (message.getMessageType().equals(MessageType.NEW_ONLINE_FRIEND)){
                    String receiver = message.getReceiver();
                    FriendList friendList = (FriendList) ClientLogin.hashMap.get(receiver);
                    String sender = message.getSender();
                    friendList.activeNewOnlineFriendIcon(sender);
                }


            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
