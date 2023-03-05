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
import java.awt.event.*;
import java.util.*;
/**
 * @author SEMHAQ
 */
public class FriendList extends JFrame implements ActionListener,MouseListener{

    public static HashMap<String,FriendChat> hashMap = new HashMap<>();

    /**
     * 好友面板
     */
    JPanel jPanelFriend;
    JButton jButtonMyfriend;
    JButton jButtonMystranger;
    JButton jButtonBlacklist;

    JScrollPane jScrollPanefriendlist;
    JPanel jPanelfriendlist;

    final int FRIENDNUM = 50;
    JLabel[] jLabelfriend = new JLabel[FRIENDNUM];

    /**
     * 陌生人面板
     */
    JPanel jPanelStranger;
    JButton jButtonMyfriendStranger;
    JButton jButtonMystrangerStranger;
    JButton jButtonBlacklistStranger;

    JScrollPane jScrollPanestrangerlist;
    JPanel jPanelstrangerlist;

    final int STRANGERNUM = 20;
    JLabel[] jLabelstranger = new JLabel[STRANGERNUM];

    /**
     * 实现两个面板之间的转换
     */
    CardLayout cardLayout;

    /**
     * 定义成员变量name
     */
    String name;


    /**
     * 好友面板初始化
     */
    public void startFriend(){
        jPanelFriend = new JPanel(new BorderLayout());

        jButtonMyfriend = new JButton("我的好友");
        jPanelFriend.add(jButtonMyfriend,"North");
        
        jPanelfriendlist = new JPanel(new GridLayout(FRIENDNUM,1));
        for (int i = 0; i < jLabelfriend.length; i++) {
            String imageUrl = "src/images/" + (int)(Math.random()*6) + ".jpg";
            ImageIcon imageIcon = new ImageIcon(imageUrl);
//            jLabelfriend[i] = new JLabel(i + "号好友",imageIcon,JLabel.LEFT);
            jLabelfriend[i] = new JLabel(i + "",imageIcon,JLabel.LEFT);

            jLabelfriend[i].addMouseListener(this);

            jPanelfriendlist.add(jLabelfriend[i]);
        }
        jScrollPanefriendlist = new JScrollPane(jPanelfriendlist);
        jPanelFriend.add(jScrollPanefriendlist,"Center");

        jButtonMystranger = new JButton("陌生人");
        jButtonMystranger.addActionListener(this);

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
        jButtonMyfriendStranger.addActionListener(this);

        jButtonMystrangerStranger = new JButton("陌生人");

        JPanel strangerPanel = new JPanel(new GridLayout(2,1));
        strangerPanel.add(jButtonMyfriendStranger);
        strangerPanel.add(jButtonMystrangerStranger);

        jPanelStranger.add(strangerPanel,"North");

        jPanelstrangerlist = new JPanel(new GridLayout(STRANGERNUM,1));
        for (int i = 0; i < jLabelstranger.length; i++) {
            jLabelstranger[i] = new JLabel(i + "号陌生人", new ImageIcon("src/images/tortoise.gif"),JLabel.LEFT);
            jPanelstrangerlist.add(jLabelstranger[i]);
        }
        jScrollPanestrangerlist = new JScrollPane(jPanelstrangerlist);
        jPanelStranger.add(jScrollPanestrangerlist,"Center");

        jButtonBlacklistStranger = new JButton("黑名单");
        jPanelStranger.add(jButtonBlacklistStranger,"South");
    }

    /**
     * 好友列表
     */
    public FriendList(String name){
        this.name = name;

        startFriend();
        startStranger();

        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(jPanelFriend,"cardFriend");
        this.add(jPanelStranger,"cardStranger");

        cardLayout.show(this.getContentPane(), "cardFriend");
//        cardLayout.show(this.getContentPane(), "cardStranger");

        this.setIconImage(new ImageIcon("src/images/duck2.gif").getImage());
        this.setTitle(name + "的好友列表");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(800,600,350,250);
        this.setVisible(true);
    }

    public static void main(String[] args) {
//        FriendList friendList = new FriendList();
    }

    /**
     * 实现好友与陌生人界面切换
     * @param e 函数自带参数
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonMystranger){
            cardLayout.show(this.getContentPane(), "cardStranger");
        }

        if (e.getSource() == jButtonMyfriendStranger){
            cardLayout.show(this.getContentPane(), "cardFriend");
        }
    }

    /**
     * 鼠标事件 跳转好友聊天
     * @param e 函数自带参数
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            JLabel jLabel = (JLabel) e.getSource();
            String toName = jLabel.getText();
//            new FriendChat(name,toName);

            FriendChat friendChat = new FriendChat(name,toName);
            hashMap.put(name+"to"+toName, friendChat);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getSource();
        jLabel.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel jLabel = (JLabel) e.getSource();
        jLabel.setForeground(Color.blue);
    }


}
