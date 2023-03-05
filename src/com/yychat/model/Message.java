package com.yychat.model;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:14:22
 * File:Message.java
 * Software:IntelliJ IDEA
 */
import java.io.*;
public class Message implements Serializable,MessageType{
    String messageType;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

}
