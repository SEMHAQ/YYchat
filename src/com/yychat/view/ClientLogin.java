package com.yychat.view;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月03日
 * Time:16:35
 * File:ClientLogin.java
 * Software:IntelliJ IDEA
 */

import javax.swing.*;
/**
 * @author SEMHAQ
 */
public class ClientLogin extends JFrame{
    JLabel jLabel = new JLabel();

    public ClientLogin(){
        jLabel = new JLabel("JAVA教学聊天室");
        this.add(jLabel, "North");

        this.setBounds(800,600,350,250);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ClientLogin clientLogin = new ClientLogin();
    }


}
