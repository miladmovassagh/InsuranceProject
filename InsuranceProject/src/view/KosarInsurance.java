package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KosarInsurance {
    private JFrame jFrame;

    public KosarInsurance() {
        jFrame = new JFrame("Kosar Insurance");
        jFrame.setSize(400, 400);
        jFrame.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.ITALIC, 28);
        ImageIcon icon = new ImageIcon("Icon\\Kosar.jpg");
        JButton btnLogin = new JButton("Login Employees");
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setFont(font);
        btnLogin.setVisible(true);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                KosarInsuranceEmployeesLogin kosarInsuranceEmployeesLogin = new KosarInsuranceEmployeesLogin();
                kosarInsuranceEmployeesLogin.login();
            }
        });
        JButton btnSignUp = new JButton("Sign Up Employees");
        btnSignUp.setBackground(Color.WHITE);
        btnSignUp.setFont(font);
        btnSignUp.setVisible(true);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                KosarInsuranceEmployeesSignUp kosarInsuranceEmployeesSignUp = new KosarInsuranceEmployeesSignUp();
                kosarInsuranceEmployeesSignUp.signUp();
            }
        });
        JButton btnReturn = new JButton("Return");
        btnReturn.setBackground(Color.WHITE);
        btnReturn.setFont(font);
        btnReturn.setVisible(true);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new MainInsurance();
            }
        });
        jFrame.add(btnLogin);
        jFrame.add(btnSignUp);
        jFrame.add(btnReturn);
        jFrame.setIconImage(icon.getImage());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(3, 0));
        jFrame.setVisible(true);
    }
}
