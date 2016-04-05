package com.team2.store.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authorization extends JFrame{

    private static JFrame sign_up;

    private static Toolkit toolkit;

    private static int screenWidth;
    private static int screenHeight;

    private static int frameWidth;
    private static int frameHeight;

    public Authorization() {
        sign_up = new JFrame("Registration");
        sign_up.setResizable(false);
        sign_up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSize();
        sign_up.setLayout(null);
        sign_up.setLocationRelativeTo(null);
        sign_up.getContentPane().setBackground(Color.LIGHT_GRAY);
        RegistrationPage();
        sign_up.setVisible(true);
    }

    private static void screenSize(){
        toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        sign_up.setSize((screenWidth*2)/3, (screenHeight*2)/3);
        sign_up.setLocationByPlatform(true);
    }

    private static void RegistrationPage() {

        frameWidth = (screenWidth*2)/3;
        frameHeight = (screenHeight*2)/3;

        JLabel reg = new JLabel("Registration form");
        reg.setFont(new Font("Sen-serif",Font.BOLD, 30));
        reg.setBounds(frameWidth/3, frameHeight/30, 250, 40);
        sign_up.add(reg);

        JLabel regFullName = new JLabel("Full Name: ");
        regFullName.setFont(new Font("Sen-serif",Font.BOLD, 16));
        regFullName.setBounds(270, 60, 100, 40);
        sign_up.add(regFullName);

        JTextField regFullNameField = new JTextField();
        regFullNameField.setBounds(370, 68, 210, 25);
        sign_up.add(regFullNameField);

        JLabel regLog = new JLabel("Login: ");
        regLog.setFont(new Font("Sen-serif",Font.BOLD, 16));
        regLog.setBounds(270, 90, 100, 40);
        sign_up.add(regLog);

        JTextField regLogField = new JTextField();
        regLogField.setBounds(370, 98, 210, 25);
        sign_up.add(regLogField);

        JLabel regPass = new JLabel("Password: ");
        regPass.setFont(new Font("Sen-serif",Font.BOLD, 16));
        regPass.setBounds(270, 120, 100, 40);
        sign_up.add(regPass);

        JTextField regPassField = new JTextField();
        regPassField.setBounds(370, 129, 210, 25);
        sign_up.add(regPassField);

        JLabel regPassAgain = new JLabel("Password*: ");
        regPassAgain.setFont(new Font("Sen-serif",Font.BOLD, 16));
        regPassAgain.setBounds(270, 150, 300, 40);
        sign_up.add(regPassAgain);

        JTextField regPassAgainField = new JTextField();
        regPassAgainField.setBounds(370, 160, 210, 25);
        sign_up.add(regPassAgainField);

        JButton regButton = new JButton("register");
        regButton.setBounds(310, 230, 100, 20);
        regButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn si = new SignIn();
                // твій код по поводу реєстрації, щоб добавилог в БД
                sign_up.setVisible(false);
            }
        } );
        sign_up.add(regButton);

        JButton regCencel = new JButton("cencel");
        regCencel.setBounds(440, 230, 100, 20);
        regCencel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn si = new SignIn();
                sign_up.setVisible(false);
            }
        } );
        sign_up.add(regCencel);
    }


}
