package com.yychat.model;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:14:22
 * File:Message.java
 * Software:IntelliJ IDEA
 */
import java.io.*;
import java.util.Date;

public class Message implements Serializable,MessageType{
    String sender;
    String receiver;
    String content;
    String messageType;

    Date sendTime;

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
