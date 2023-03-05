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
public class yychatClientConnection {
    Socket socket;

    public yychatClientConnection(){
        try {
            socket = new Socket("127.0.0.1",5000);
            System.out.println("Successfully Connected" + socket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
