package com.yychat.view;

/**
 * Author:SEMHAQ
 * Date:2023年 03 月03日
 * Time:16:35
 * File:ClientLogin.java
 * Software:IntelliJ IDEA
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.yychat.control.yychatClientConnection;
import com.yychat.model.User;
/**
 * @author SEMHAQ
 */
public class ClientLogin extends JFrame implements ActionListener {
    JLabel jLabel;
    JButton jButtonLogin,jButtonRegister,jButtonCancel;
    JPanel jPanel;
    JLabel jLabelAccount,jLabelPassword,jLabelForget,jLabelProtect;
    JButton jButtonClear;
    JTextField jTextField;
    JPasswordField jPasswordField;
    JCheckBox jCheckBoxInvisible,jCheckBoxRemember;
    JTabbedPane jTabbedPane;
    JPanel jPanelyynum,jPanelPhonenum,jPanelemail;

    Image image;

    /**
     * JLabel初始化
     */
    public void startJlabel(){
        //        jLabel = new JLabel("JAVA教学聊天室");
        jLabel = new JLabel(new ImageIcon("src/images/head.gif"));
        this.add(jLabel, "North");

        jLabelAccount = new JLabel("YY号码：", SwingConstants.CENTER);
        jLabelPassword = new JLabel("YY密码：", SwingConstants.CENTER);
        jLabelForget = new JLabel("忘记密码", SwingConstants.CENTER);
        jLabelForget.setForeground(Color.blue);

        jLabelProtect = new JLabel("申请密码保护",SwingConstants.CENTER);
    }

    /**
     * JButton初始化
     */
    public void startJbutton(){
        //        jButtonLogin = new NewButton("登录",50,30);
        jButtonLogin = new JButton(new ImageIcon("src/images/login.gif"));
        jButtonLogin.addActionListener(this);

        jButtonRegister = new JButton(new ImageIcon("src/images/register.gif"));
        jButtonCancel = new JButton(new ImageIcon("src/images/cancel.gif"));
        jButtonClear = new JButton(new ImageIcon("src/images/clear.gif"));
    }

    /**
     * JPanel初始化
     */
    public void startJpanel(){
        jPanel = new JPanel();
        jPanel.add(jButtonLogin);
        jPanel.add(jButtonRegister);
        jPanel.add(jButtonCancel);
        this.add(jPanel,"South");

        //jPanelyynum初始化
        jPanelyynum = new JPanel(new GridLayout(3, 3));

        //Line 1
        jPanelyynum.add(jLabelAccount);
        jPanelyynum.add(jTextField);
        jPanelyynum.add(jButtonClear);

        //Line 2
        jPanelyynum.add(jLabelPassword);
        jPanelyynum.add(jPasswordField);
        jPanelyynum.add(jLabelForget);

        //Line 3
        jPanelyynum.add(jCheckBoxInvisible);
        jPanelyynum.add(jCheckBoxRemember);
        jPanelyynum.add(jLabelProtect);

        //jPanelPhonenum & jPanelemail 初始化
        jPanelPhonenum = new JPanel();
        jPanelemail = new JPanel();
    }


    /**
     * JTextField初始化
     */
    public void startJtextfield(){
        jTextField = new JTextField();
    }


    /**
     * JPasswordField初始化
     */
    public void startJpasswordfield(){
        jPasswordField = new JPasswordField();
    }

    /**
     * JCheckBox初始化
     */
    public void startJcheckbox(){
        jCheckBoxInvisible = new JCheckBox("隐身登录");
        jCheckBoxRemember = new JCheckBox("记住密码");
    }


    /**
     * JTabbedPane初始化
     */
    public void startJtabbedpane(){
        jTabbedPane = new JTabbedPane();
        jTabbedPane.add(jPanelyynum,"YY号码");
        jTabbedPane.add(jPanelPhonenum,"手机号码");
        jTabbedPane.add(jPanelemail,"电子邮箱");

        this.add(jTabbedPane,"Center");
    }


    /**
     * Image初始化
     */
    public void startImage(){
        image = new ImageIcon("src/images/duck2.gif").getImage();
        this.setIconImage(image);
    }


    /**
     * 登录界面
     */
    public ClientLogin(){
        startJlabel();
        startJbutton();
        startJtextfield();
        startJpasswordfield();
        startJcheckbox();
        startImage();
        startJpanel();
        startJtabbedpane();

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


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonLogin){
            String name = jTextField.getText();
            String password = new String(jPasswordField.getPassword());

            User user = new User();
            user.setUsername(name);
            user.setPassword(password);


            if (new yychatClientConnection().loginValidate(user)){
                new FriendList(name);
                System.out.println("Login Successfully");
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this,"密码错误，请重新登录！");
            }



        }





    }

}
