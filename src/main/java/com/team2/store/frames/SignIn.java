package com.team2.store.frames;


import com.team2.store.Constants;
import com.team2.store.entities.User;
import com.team2.store.service.IUserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame{

    private static JFrame sign_in;

    private static Toolkit toolkit;

    private static int screenWidth;
    private static int screenHeight;

    private static int frameWidth;
    private static int frameHeight;

    public SignIn() {
        sign_in = new JFrame("Main");
        screenSize();
        sign_in.setResizable(false);
        sign_in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sign_in.setLayout(null);
        sign_in.setLocationRelativeTo(null);
        sign_in.getContentPane().setBackground(Color.LIGHT_GRAY);

        signInPage();

        sign_in.setVisible(true);
    }

    public static void screenSize(){
        toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        sign_in.setSize((screenWidth*2)/3, (screenHeight*2)/3);
        sign_in.setLocationByPlatform(true);
    }

    private static void signInPage(){

        frameWidth = (screenWidth*2)/3;
        frameHeight = (screenHeight*2)/3;

        JLabel title = new JLabel("Welcome to the store 'Apple'");
        title.setBounds(frameWidth/4, frameHeight/4, 470, 40);
        title.setFont(new Font("Sen-serif",Font.BOLD, 35));
        sign_in.add(title);

        JLabel log = new JLabel("Login: ");
        log.setBounds((frameWidth/2-100), (frameHeight/2-40), 100, 40);
        log.setFont(new Font("Sen-serif",Font.BOLD, 14));
        sign_in.add(log);

        final JTextField logTextField = new JTextField();
        logTextField.setBounds((frameWidth/2), (frameHeight/2-30), 100, 25);
        sign_in.add(logTextField);

        JLabel pass = new JLabel("Password: ");
        pass.setBounds((frameWidth/2-100), (frameHeight/2-5), 100, 40);
        pass.setFont(new Font("Sen-serif",Font.BOLD, 14));
        sign_in.add(pass);

        final JTextField passTextField = new JTextField();
        passTextField.setBounds((frameWidth/2), (frameHeight/2+2), 100, 25);
        sign_in.add(passTextField);

        JButton login = new JButton("login");
        login.setBounds((frameWidth/2-100), (frameHeight/2+40), 75, 20);
        login.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IUserService userService = (IUserService) Constants.context.getBean("userService");
                String login = logTextField.getText();
                String password = passTextField.getText();
                User user = userService.login(login,password);
                if(user!=null){
                    Constants.currentUser = user;
                    AddGoods addGoods = new AddGoods();
                    sign_in.setVisible( false );
                }else{
                    System.err.println("INCORRECT LOGIN OR PASSWORD!");
                }
            }
        } );
        sign_in.add(login);

        /*JButton register = new JButton("registration");
        register.setBounds((frameWidth/2), (frameHeight/2+40), 100, 20);
        register.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Authorization a = new Authorization();
                sign_in.setVisible(false);
            }
        });
        sign_in.add(register);*/

    }

}
