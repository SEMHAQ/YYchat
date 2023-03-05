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
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

}