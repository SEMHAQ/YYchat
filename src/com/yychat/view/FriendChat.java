package com.yychat.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月04日
 * Time:13:18
 * File:FriendChat.java
 * Software:IntelliJ IDEA
 */
public class FriendChat extends JFrame implements ActionListener {
    JTextArea jTextArea;
    JScrollPane jScrollPane;
    JTextField jTextField;
    JButton jButton;

    public FriendChat(String onetoAnother){
        startjTextArea();
        startjScrollPane();
        startjTextField();
        startjButton();
        startjPanel();

        this.setSize(350,250);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("聊天界面");
        this.setIconImage(new ImageIcon("src/images/duck2.gif").getImage());
        this.setVisible(true);
    }

    /**
     * jTextArea初始化
     */
    public void startjTextArea(){
        jTextArea = new JTextArea();
        jTextArea.setForeground(Color.red);
    }

    /**
     * jScrollPane初始化
     */
    public void startjScrollPane(){
        jScrollPane = new JScrollPane(jTextArea);
        this.add(jScrollPane, "Center");
    }

    /**
     * jTextField初始化
     */
    public void startjTextField(){
        jTextField = new JTextField(15);
    }

    /**
     * jButton初始化
     */
    public void startjButton(){
        jButton = new JButton("发送");
        jButton.addActionListener(this);
        jButton.setForeground(Color.blue);
    }

    /**
     * jPanel初始化
     */
    public void startjPanel(){
        JPanel jPanel = new JPanel();
        jPanel.add(jTextField);
        jPanel.add(jButton);
        this.add(jPanel,"South");
    }

    public static void main(String[] args) {
//        FriendChat friendChat = new FriendChat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            jTextArea.append(jTextField.getText() + "\r\n");
        }
    }
}
