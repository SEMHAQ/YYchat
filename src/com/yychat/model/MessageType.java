package com.yychat.model;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月05日
 * Time:14:21
 * File:MessageType.java
 * Software:IntelliJ IDEA
 */
public interface MessageType {
    String LOGIN_SUCCESS = "1";
    String LOGIN_FAILURE = "2";
    String CHAT_MESSAGE = "3";

    String REQUEST_ONLINE_FRIEND = "4";
    String RESPONSE_ONLINE_FRIEND = "5";
}
