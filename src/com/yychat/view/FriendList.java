package com.yychat.view;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月03日
 * Time:20:03
 * File:FriendList.java
 * Software:IntelliJ IDEA
 */
import javax.swing.*;
import java.awt.*;

/**
 * @author SEMHAQ
 */
public class FriendList extends JFrame{
    /**
     * 好友面板
     */
    JPanel jPanelFriend;
    JButton jButtonMyfriend;
    JButton jButtonMystranger;
    JButton jButtonBlacklist;

    /**
     * 陌生人面板
     */
    JPanel jPanelStranger;
    JButton jButtonMyfriendStranger;
    JButton jButtonMystrangerStranger;
    JButton jButtonBlacklistStranger;

    /**
     * 好友面板初始化
     */
    public void startFriend(){
        jPanelFriend = new JPanel(new BorderLayout());

        jButtonMyfriend = new JButton("我的好友");
        jPanelFriend.add(jButtonMyfriend,"North");

        jButtonMystranger = new JButton("陌生人");
        jButtonBlacklist = new JButton("黑名单");

        JPanel strangerPanel = new JPanel(new GridLayout(2,1));
        strangerPanel.add(jButtonMystranger);
        strangerPanel.add(jButtonBlacklist);

        jPanelFriend.add(strangerPanel,"South");
    }

    /**
     * 陌生人面板初始化
     */
    public void startStranger(){
        jPanelStranger = new JPanel(new BorderLayout());
        jButtonMyfriendStranger = new JButton("我的好友");
        jButtonMystrangerStranger = new JButton("陌生人");

        JPanel strangerPanel = new JPanel(new GridLayout(2,1));
        strangerPanel.add(jButtonMyfriendStranger);
        strangerPanel.add(jButtonMystrangerStranger);

        jPanelStranger.add(strangerPanel,"North");

        jButtonBlacklistStranger = new JButton("黑名单");
        jPanelStranger.add(jButtonBlacklistStranger,"South");
    }

    /**
     * 好友列表
     */
    public FriendList(){
        startFriend();
        startStranger();

        CardLayout cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(jPanelFriend,"cardFriend");
        this.add(jPanelStranger,"cardStranger");

//        cardLayout.show(this.getContentPane(), "cardFriend");
        cardLayout.show(this.getContentPane(), "cardStranger");

        this.setIconImage(new ImageIcon("src/images/duck2.gif").getImage());
        this.setTitle("好友列表");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(800,600,350,250);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        FriendList friendList = new FriendList();
    }

}
