package com.yychat.server.view;


import javax.swing.*;
import java.awt.*;
/**
 * Author:SEMHAQ
 * Date:2023年 03 月04日
 * Time:18:53
 * File:StartSever.java
 * Software:IntelliJ IDEA
 */
public class StartSever extends JFrame{
    JButton jButtonStart,jButtonStop;

    public StartSever(){
        startJbutton();

        this.setLayout(new GridLayout(1,2));
        this.add(jButtonStart);
        this.add(jButtonStop);
        this.setSize(400,100);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("src/images/duck2.gif").getImage());
        this.setTitle("YYchat Server");
        this.setVisible(true);
    }

    /**
     * JButton初始化
     */
    public void startJbutton(){
        jButtonStart = new JButton("启动服务器");
        jButtonStart.setFont(new Font("宋体",Font.BOLD,25));

        jButtonStop = new JButton("停止服务器");
        jButtonStop.setFont(new Font("宋体",Font.BOLD,25));
    }

    public static void main(String[] args) {
        StartSever startSever = new StartSever();
    }

}
