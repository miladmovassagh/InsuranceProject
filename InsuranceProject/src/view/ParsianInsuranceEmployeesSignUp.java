package view;

import controller.ParsianInsuranceEmployeesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ParsianInsuranceEmployeesSignUp {
    public static JFrame jFrame;

    public void signUp() {
        jFrame = new JFrame("Employees Sign Up Form");
        jFrame.setSize(450, 700);
        jFrame.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.PLAIN, 18);
        ImageIcon icon = new ImageIcon("Icon\\Parsian.jpg");
        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(15, 5, 150, 30);
        lblFullName.setFont(font);
        lblFullName.setVisible(true);
        JTextField txtFullName = new JTextField();
        txtFullName.setBounds(150, 10, 220, 25);
        txtFullName.setVisible(true);
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(15, 48, 150, 30);
        lblUsername.setFont(font);
        lblUsername.setVisible(true);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 53, 220, 25);
        txtUsername.setVisible(true);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(15, 91, 150, 30);
        lblPassword.setFont(font);
        lblPassword.setVisible(true);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 96, 220, 25);
        txtPassword.setVisible(true);
        JLabel lblNationalId = new JLabel("National Id:");
        lblNationalId.setBounds(15, 134, 150, 30);
        lblNationalId.setFont(font);
        lblNationalId.setVisible(true);
        JTextField txtNationalId = new JTextField();
        txtNationalId.setBounds(150, 139, 220, 25);
        txtNationalId.setVisible(true);
        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(15, 177, 150, 30);
        lblPhoneNumber.setFont(font);
        lblPhoneNumber.setVisible(true);
        JTextField txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(150, 182, 220, 25);
        txtPhoneNumber.setVisible(true);
        JLabel lblHomePhone = new JLabel("Home Phone:");
        lblHomePhone.setBounds(15, 220, 150, 30);
        lblHomePhone.setFont(font);
        lblHomePhone.setVisible(true);
        JTextField txtHomePhone = new JTextField();
        txtHomePhone.setBounds(150, 225, 220, 25);
        txtHomePhone.setVisible(true);
        JLabel lblBirthDate = new JLabel("Birth Date:");
        lblBirthDate.setBounds(15, 263, 150, 30);
        lblBirthDate.setFont(font);
        lblBirthDate.setVisible(true);
        String[] day = new String[31];
        for(int i = 0; i < 31; i++)
            day[i] = Integer.toString(i+1);
        String[] month = new String[12];
        for(int i = 0; i < 12; i++)
            month[i] = Integer.toString(i+1);
        String[] year = new String[100];
        for(int i = 0, j = 1399; i < 100; i++, j--)
            year[i] = Integer.toString(j);
        JComboBox<String> cmBoxDay = new JComboBox<>(day);
        cmBoxDay.setBounds(310, 268, 55, 25);
        cmBoxDay.setBackground(Color.WHITE);
        JComboBox<String> cmBoxMonth = new JComboBox<>(month);
        cmBoxMonth.setBounds(240, 268, 55, 25);
        cmBoxMonth.setBackground(Color.WHITE);
        JComboBox<String> cmBoxYear = new JComboBox<>(year);
        cmBoxYear.setBounds(150, 268, 70, 25);
        cmBoxYear.setBackground(Color.WHITE);
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(15, 306, 150, 30);
        lblAddress.setFont(font);
        lblAddress.setVisible(true);
        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(150, 311, 220, 25);
        txtAddress.setVisible(true);
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(15, 351, 150, 30);
        lblEmail.setFont(font);
        lblEmail.setVisible(true);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(150, 356, 220, 25);
        txtEmail.setVisible(true);
        JLabel lblEducation = new JLabel("Education:");
        lblEducation.setBounds(15, 394, 150, 30);
        lblEducation.setFont(font);
        lblEducation.setVisible(true);
        JTextField txtEducation = new JTextField();
        txtEducation.setBounds(150, 399, 220, 25);
        txtEducation.setVisible(true);
        JLabel lblStudyField = new JLabel("Study Field:");
        lblStudyField.setBounds(15, 437, 150, 30);
        lblStudyField.setFont(font);
        lblStudyField.setVisible(true);
        JTextField txtStudyField = new JTextField();
        txtStudyField.setBounds(150, 442, 220, 25);
        txtStudyField.setVisible(true);
        JLabel lblMaritalStatus = new JLabel("Marital Status:");
        lblMaritalStatus.setBounds(15, 480, 150, 30);
        lblMaritalStatus.setFont(font);
        lblMaritalStatus.setVisible(true);
        JRadioButton radioBtn1 = new JRadioButton("Single");
        radioBtn1.setBounds(160, 485, 100, 30);
        radioBtn1.setBackground(Color.WHITE);
        radioBtn1.setFont(font);
        JRadioButton radioBtn2 = new JRadioButton("Married");
        radioBtn2.setBounds(280, 485, 100, 30);
        radioBtn2.setBackground(Color.WHITE);
        radioBtn2.setFont(font);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn1);
        btnGroup.add(radioBtn2);
        radioBtn1.setSelected(true);
        JLabel lblWorkExperience = new JLabel("Work Experience:");
        lblWorkExperience.setBounds(15, 523, 150, 30);
        lblWorkExperience.setFont(font);
        lblWorkExperience.setVisible(true);
        SpinnerModel workExperience = new SpinnerNumberModel(0, 0, 30, 1);
        JSpinner spinnerWorkExperience = new JSpinner(workExperience);
        spinnerWorkExperience.setBounds(230, 528, 50, 25);
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(230, 590, 100, 40);
        btnSignUp.setBackground(Color.DARK_GRAY);
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(font);
        btnSignUp.setVisible(true);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maritalStatus = radioBtn1.isSelected() ? "Single":"Married";
                String day = (Integer.parseInt(cmBoxDay.getSelectedItem().toString()) < 10) ? ("0" + cmBoxDay.getSelectedItem().toString()):cmBoxDay.getSelectedItem().toString();
                String month = (Integer.parseInt(cmBoxMonth.getSelectedItem().toString()) < 10) ? ("0" + cmBoxMonth.getSelectedItem().toString()):cmBoxMonth.getSelectedItem().toString();
                String year = cmBoxYear.getSelectedItem().toString();
                String birthDate = year + "/" + month + "/" + day;
                try {
                    ParsianInsuranceEmployeesController.getInstance().insert(txtFullName.getText(), txtUsername.getText(), txtPassword.getText(), txtNationalId.getText(), txtPhoneNumber.getText(), txtHomePhone.getText(),
                            birthDate, txtAddress.getText(), txtEmail.getText(), txtEducation.getText(), txtStudyField.getText(), maritalStatus, Integer.parseInt(spinnerWorkExperience.getValue().toString()));
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton btnReturn = new JButton("Return");
        btnReturn.setBounds(110, 590, 100, 40);
        btnReturn.setBackground(Color.DARK_GRAY);
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(font);
        btnReturn.setVisible(true);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParsianInsurance();
                jFrame.dispose();
            }
        });
        jFrame.add(lblFullName);
        jFrame.add(txtFullName);
        jFrame.add(lblUsername);
        jFrame.add(txtUsername);
        jFrame.add(lblPassword);
        jFrame.add(txtPassword);
        jFrame.add(lblNationalId);
        jFrame.add(txtNationalId);
        jFrame.add(lblPhoneNumber);
        jFrame.add(txtPhoneNumber);
        jFrame.add(lblHomePhone);
        jFrame.add(txtHomePhone);
        jFrame.add(lblBirthDate);
        jFrame.add(cmBoxDay);
        jFrame.add(cmBoxMonth);
        jFrame.add(cmBoxYear);
        jFrame.add(lblAddress);
        jFrame.add(txtAddress);
        jFrame.add(lblEmail);
        jFrame.add(txtEmail);
        jFrame.add(lblEducation);
        jFrame.add(txtEducation);
        jFrame.add(lblStudyField);
        jFrame.add(txtStudyField);
        jFrame.add(lblMaritalStatus);
        jFrame.add(radioBtn1);
        jFrame.add(radioBtn2);
        jFrame.add(lblWorkExperience);
        jFrame.add(spinnerWorkExperience);
        jFrame.add(btnSignUp);
        jFrame.add(btnReturn);
        jFrame.setIconImage(icon.getImage());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
