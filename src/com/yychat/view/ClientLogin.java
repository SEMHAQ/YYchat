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
    JLabel jLabel;
    JButton jButtonLogin,jButtonRegister,jButtonCancel;
    JPanel jPanel;

    public ClientLogin(){
//        jLabel = new JLabel("JAVA教学聊天室");
        jLabel = new JLabel(new ImageIcon("src/images/head.gif"));
        this.add(jLabel, "North");

//        jButtonLogin = new NewButton("登录",50,30);
        jButtonLogin = new JButton(new ImageIcon("src/images/login.gif"));
        jButtonRegister = new JButton(new ImageIcon("src/images/register.gif"));
        jButtonCancel = new JButton(new ImageIcon("src/images/cancel.gif"));

        jPanel = new JPanel();
        jPanel.add(jButtonLogin);
        jPanel.add(jButtonRegister);
        jPanel.add(jButtonCancel);
        this.add(jPanel,"South");

//        this.setBounds(800,600,350,250);
        this.setLocationRelativeTo(null);
        this.setSize(350,250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("YYchat");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ClientLogin clientLogin = new ClientLogin();
    }


}
