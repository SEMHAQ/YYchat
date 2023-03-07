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

    String NEW_ONLINE_TO_ALLFRIEND = "6";
    String NEW_ONLINE_FRIEND = "7";

    String USER_REGISTER_SUCCESS = "8";
    String USER_REGISTER_FAILURE = "9";

    String ADD_NEW_FRIEND = "10";

    String ADD_NEW_FRIEND_FAILURE_NO_USER = "11";
    String ADD_NEW_FRIEND_FAILURE_ALREADY_FRIEND = "12";
    String ADD_NEW_FRIEND_SUCCESS = "13";
}
