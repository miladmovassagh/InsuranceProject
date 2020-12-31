package view;

import controller.IranInsuranceEmployeesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IranInsuranceEmployeesLogin {
    public static JFrame jFrame;

    public void login() {
        jFrame = new JFrame("Employees Login");
        jFrame.setSize(350, 400);
        jFrame.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.PLAIN, 18);
        ImageIcon icon = new ImageIcon("Icon\\Iran.jpg");
        JLabel lblTxt = new JLabel("Employees Login");
        lblTxt.setBounds(100, 10, 300, 50);
        lblTxt.setFont(font);
        lblTxt.setVisible(true);
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(15, 80, 100, 30);
        lblUsername.setFont(font);
        lblUsername.setVisible(true);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(105, 85, 180, 25);
        txtUsername.setVisible(true);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(15, 160, 100, 30);
        lblPassword.setFont(font);
        lblPassword.setVisible(true);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(105, 165, 180, 25);
        txtPassword.setVisible(true);
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(180, 260, 100, 40);
        btnLogin.setBackground(Color.DARK_GRAY);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(font);
        btnLogin.setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    IranInsuranceEmployeesController.getInstance().select(txtUsername.getText(), txtPassword.getText());
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton btnReturn = new JButton("Return");
        btnReturn.setBounds(50, 260, 100, 40);
        btnReturn.setBackground(Color.DARK_GRAY);
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(font);
        btnReturn.setVisible(true);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IranInsurance();
                jFrame.dispose();
            }
        });
        jFrame.add(lblTxt);
        jFrame.add(lblUsername);
        jFrame.add(txtUsername);
        jFrame.add(lblPassword);
        jFrame.add(txtPassword);
        jFrame.add(btnLogin);
        jFrame.add(btnReturn);
        jFrame.setIconImage(icon.getImage());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
