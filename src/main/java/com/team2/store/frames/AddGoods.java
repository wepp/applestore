package com.team2.store.frames;

import com.team2.store.Constants;
import com.team2.store.entities.Product;
import com.team2.store.service.IProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Максим on 22.02.2016.
 */
public class AddGoods extends JFrame {

    private static JFrame addition;

    private static Toolkit toolkit;

    private static int screenWidth;
    private static int screenHeight;

    private static int frameWidth;
    private static int frameHeight;

    public AddGoods(){
        addition = new JFrame("Add goods");
        addition.setResizable(false);
        addition.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSize();
        addition.setLayout(null);
        addition.setLocationRelativeTo(null);
        addition.getContentPane().setBackground(Color.LIGHT_GRAY);
        addGoods();
        addition.setVisible(true);
    }

    private static void screenSize(){
        toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        addition.setSize((screenWidth*2)/3, (screenHeight*2)/3);
        addition.setLocationByPlatform(true);
    }

    private static void addGoods() {

        frameWidth = (screenWidth*2)/3;
        frameHeight = (screenHeight*2)/3;


        JLabel mainLabel = new JLabel("Addition of goods");
        mainLabel.setFont(new Font("Sen-serif",Font.BOLD, 30));
        mainLabel.setBounds(320,50,300,40);
        addition.add(mainLabel);

        JLabel addLabel = new JLabel("Name of good: ");
        addLabel.setFont(new Font("Sen-serif",Font.BOLD, 14));
        addLabel.setBounds(150,150,140,25);
        addition.add(addLabel);

        final JTextField addTextField = new JTextField();
        addTextField.setBounds(270, 150, 200, 30);
        addition.add(addTextField);

        JLabel numberLabel = new JLabel("Number: ");
        numberLabel.setFont(new Font("Sen-serif",Font.BOLD, 14));
        numberLabel.setBounds(480,150,80,25);
        addition.add(numberLabel);

        final JTextField intTextField = new JTextField();
        intTextField.setBounds(560,150,80,30);
        addition.add(intTextField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(660,150,100,30);
        addButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Success");
                String productName = addTextField.getText();
                int productCount = Integer.parseInt(intTextField.getText());
                IProductService productService = (IProductService) Constants.context.getBean("productService");
                Product product = new Product();
                product.setProductName(productName);
                product.setCount(productCount);
                productService.addNewProduct(product);
                frame.setLayout(null);
                frame.setLocationRelativeTo(null);
                frame.setSize(400,200);
                JLabel label = new JLabel("Good has been added!");
                label.setFont(new Font("Sen-serif", Font.BOLD, 14));
                label.setBounds(50,80,200,30);
                frame.add(label);

                frame.setVisible(true);
            }
        });
        addition.add(addButton);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Object[] headers = { "id", "Name", "Count" };
        IProductService productService = (IProductService) Constants.context.getBean("productService");
        List<Product> allProducts = productService.getAll();
        System.out.println(allProducts);
        //Массив содержащий информацию для таблицы
        Object[][] data = new Object[allProducts.size()][3];
        for(int i=0;i<allProducts.size();i++){
            data[i][0] = allProducts.get(i).getProduct_id();
            data[i][1] = allProducts.get(i).getProductName();
            data[i][2] = allProducts.get(i).getCount();
        }

        panel.setLayout(new GridLayout(2,0));

        JLabel labelP = new JLabel();
        panel.add(labelP);


        JTable jTabPeople = new JTable(data, headers);

        JScrollPane jscrlp = new JScrollPane(jTabPeople);

        panel.setSize(frameWidth, frameHeight);

        panel.add(jscrlp);

        panel.setVisible(true);

        addition.add(panel);

    }



}
