package view;

import controller.AlborzInsuranceServicesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Random;

public class AlborzInsuranceServices {
    public static JFrame jFrame, jFrame1, jFrame2, jFrame3;

    public AlborzInsuranceServices() {
        jFrame = new JFrame("Alborz Insurance Services");
        jFrame.setSize(400, 400);
        jFrame.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.ITALIC, 26);
        ImageIcon icon = new ImageIcon("Icon\\Alborz.jpeg");
        JButton btnRegister = new JButton("Register new insurance");
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setFont(font);
        btnRegister.setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerNewInsurance();
                jFrame.dispose();
                JOptionPane.showMessageDialog(null, "Receive the following items from the customer and then fill in the form\n1: Identification documents and customer details\n2: Service payment tracking code (14000 toman)\n3: Document or property number or work confirmation number\n(Depending on the type of insurance)");
            }
        });
        JButton btnPay = new JButton("Pay the annual premium");
        btnPay.setBackground(Color.WHITE);
        btnPay.setFont(font);
        btnPay.setVisible(true);
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payAnnualPremium();
                jFrame.dispose();
                JOptionPane.showMessageDialog(null, "Receive the payment code and tracking code of the\nannual premium payment (1000000 toman) from the customer");
            }
        });
        JButton btnCancel = new JButton("Cancellation of insurance");
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setFont(font);
        btnCancel.setVisible(true);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contractInsuranceCancellation();
                jFrame.dispose();
                JOptionPane.showMessageDialog(null, "Receive the payment code from the customer");
            }
        });
        JButton btnExit = new JButton("Exit");
        btnExit.setBackground(Color.WHITE);
        btnExit.setFont(font);
        btnExit.setVisible(true);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });
        jFrame.add(btnRegister);
        jFrame.add(btnPay);
        jFrame.add(btnCancel);
        jFrame.add(btnExit);
        jFrame.setIconImage(icon.getImage());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(4, 0));
        jFrame.setVisible(true);
    }

    public void registerNewInsurance() {
        long salary = 10000000;
        jFrame1 = new JFrame("Register New Insurance Form");
        jFrame1.setSize(450, 700);
        jFrame1.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.PLAIN, 17);
        ImageIcon icon = new ImageIcon("Icon\\Alborz.jpeg");
        JLabel lblFullName = new JLabel("Full Name:");
        lblFullName.setBounds(15, 5, 150, 30);
        lblFullName.setFont(font);
        lblFullName.setVisible(true);
        JTextField txtFullName = new JTextField();
        txtFullName.setBounds(150, 10, 220, 25);
        txtFullName.setVisible(true);
        JLabel lblNationalId = new JLabel("National Id:");
        lblNationalId.setBounds(15, 45, 150, 30);
        lblNationalId.setFont(font);
        lblNationalId.setVisible(true);
        JTextField txtNationalId = new JTextField();
        txtNationalId.setBounds(150, 50, 220, 25);
        txtNationalId.setVisible(true);
        JLabel lblCertificateId = new JLabel("Certificate Id:");
        lblCertificateId.setBounds(15, 85, 150, 30);
        lblCertificateId.setFont(font);
        lblCertificateId.setVisible(true);
        JTextField txtCertificateId = new JTextField();
        txtCertificateId.setBounds(150, 90, 220, 25);
        txtCertificateId.setVisible(true);
        JLabel lblFatherName = new JLabel("Father Name:");
        lblFatherName.setBounds(15, 125, 150, 30);
        lblFatherName.setFont(font);
        lblFatherName.setVisible(true);
        JTextField txtFatherName = new JTextField();
        txtFatherName.setBounds(150, 130, 220, 25);
        txtFatherName.setVisible(true);
        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setBounds(15, 165, 150, 30);
        lblPhoneNumber.setFont(font);
        lblPhoneNumber.setVisible(true);
        JTextField txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(150, 170, 220, 25);
        txtPhoneNumber.setVisible(true);
        JLabel lblHomePhone = new JLabel("Home Phone:");
        lblHomePhone.setBounds(15, 205, 150, 30);
        lblHomePhone.setFont(font);
        lblHomePhone.setVisible(true);
        JTextField txtHomePhone = new JTextField();
        txtHomePhone.setBounds(150, 210, 220, 25);
        txtHomePhone.setVisible(true);
        JLabel lblBirthDate = new JLabel("Birth Date:");
        lblBirthDate.setBounds(15, 245, 150, 30);
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
        cmBoxDay.setBounds(310, 250, 55, 25);
        cmBoxDay.setBackground(Color.WHITE);
        JComboBox<String> cmBoxMonth = new JComboBox<>(month);
        cmBoxMonth.setBounds(240, 250, 55, 25);
        cmBoxMonth.setBackground(Color.WHITE);
        JComboBox<String> cmBoxYear = new JComboBox<>(year);
        cmBoxYear.setBounds(150, 250, 70, 25);
        cmBoxYear.setBackground(Color.WHITE);
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(15, 285, 150, 30);
        lblAddress.setFont(font);
        lblAddress.setVisible(true);
        JTextField txtAddress = new JTextField();
        txtAddress.setBounds(150, 290, 220, 25);
        txtAddress.setVisible(true);
        JLabel lblNationality = new JLabel("Nationality:");
        lblNationality.setBounds(15, 325, 150, 30);
        lblNationality.setFont(font);
        lblNationality.setVisible(true);
        JRadioButton radioBtn1 = new JRadioButton("Iranian");
        radioBtn1.setBounds(150, 330, 100, 30);
        radioBtn1.setBackground(Color.WHITE);
        radioBtn1.setFont(font);
        JRadioButton radioBtn2 = new JRadioButton("Non Iranian");
        radioBtn2.setBounds(260, 330, 120, 30);
        radioBtn2.setBackground(Color.WHITE);
        radioBtn2.setFont(font);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn1);
        btnGroup.add(radioBtn2);
        radioBtn1.setSelected(true);
        JLabel lblUserType = new JLabel("User Type:");
        lblUserType.setBounds(15, 365, 150, 30);
        lblUserType.setFont(font);
        lblUserType.setVisible(true);
        String[] userType = {"Real","Legal","Factories","Companies","Organizations"};
        JComboBox<String> cmBoxUserType = new JComboBox<>(userType);
        cmBoxUserType.setBounds(210, 370, 90, 25);
        cmBoxUserType.setBackground(Color.WHITE);
        JLabel lblInsuranceType = new JLabel("Insurance Type:");
        lblInsuranceType.setBounds(15, 405, 150, 30);
        lblInsuranceType.setFont(font);
        lblInsuranceType.setVisible(true);
        String[] insuranceType = {"Fire","Life","Car Body","Third Party","Unemployment"};
        JComboBox<String> cmBoxInsuranceType = new JComboBox<>(insuranceType);
        cmBoxInsuranceType.setBounds(210, 410, 90, 25);
        cmBoxInsuranceType.setBackground(Color.WHITE);
        JLabel lblContractTerm = new JLabel("Contract Term:");
        lblContractTerm.setBounds(15, 445, 150, 30);
        lblContractTerm.setFont(font);
        lblContractTerm.setVisible(true);
        SpinnerModel contractTerm = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner spinnerContractTerm = new JSpinner(contractTerm);
        spinnerContractTerm.setBounds(230, 450, 50, 25);
        JLabel lblPaymentTrackingCode = new JLabel("Tracking Code:");
        lblPaymentTrackingCode.setBounds(15, 485, 150, 30);
        lblPaymentTrackingCode.setFont(font);
        lblPaymentTrackingCode.setVisible(true);
        JTextField txtPaymentTrackingCode = new JTextField();
        txtPaymentTrackingCode.setBounds(200, 490, 120, 25);
        txtPaymentTrackingCode.setVisible(true);
        JLabel lblDocumentNumber = new JLabel("Document Number:");
        lblDocumentNumber.setBounds(15, 525, 150, 30);
        lblDocumentNumber.setFont(font);
        lblDocumentNumber.setVisible(true);
        JTextField txtDocumentNumber = new JTextField();
        txtDocumentNumber.setBounds(200, 530, 120, 25);
        txtDocumentNumber.setVisible(true);
        JButton btnRegister = new JButton("Register");
        btnRegister.setBounds(230, 590, 100, 40);
        btnRegister.setBackground(Color.DARK_GRAY);
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(font);
        btnRegister.setVisible(true);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                long paymentCode = (long) random.nextInt((99999999 - 10000000) + 1) + 10000000;
                Date registrationDate = new Date();
                String nationality = radioBtn1.isSelected() ? "Iranian":"Non Iranian";
                String day = (Integer.parseInt(cmBoxDay.getSelectedItem().toString()) < 10) ? ("0" + cmBoxDay.getSelectedItem().toString()):cmBoxDay.getSelectedItem().toString();
                String month = (Integer.parseInt(cmBoxMonth.getSelectedItem().toString()) < 10) ? ("0" + cmBoxMonth.getSelectedItem().toString()):cmBoxMonth.getSelectedItem().toString();
                String year = cmBoxYear.getSelectedItem().toString();
                String birthDate = year + "/" + month + "/" + day;
                try {
                    AlborzInsuranceServicesController.getInstance().insert(txtFullName.getText(), txtNationalId.getText(), txtCertificateId.getText(), txtFatherName.getText(), txtPhoneNumber.getText(), txtHomePhone.getText(), birthDate, txtAddress.getText(), nationality,
                            cmBoxUserType.getSelectedItem().toString(), cmBoxInsuranceType.getSelectedItem().toString(), Integer.parseInt(spinnerContractTerm.getValue().toString()), registrationDate.toString(), Long.parseLong(txtPaymentTrackingCode.getText()), txtDocumentNumber.getText(), paymentCode, (salary * Integer.parseInt(spinnerContractTerm.getValue().toString())));
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
                new AlborzInsuranceServices();
                jFrame1.dispose();
            }
        });
        jFrame1.add(lblFullName);
        jFrame1.add(txtFullName);
        jFrame1.add(lblNationalId);
        jFrame1.add(txtNationalId);
        jFrame1.add(lblCertificateId);
        jFrame1.add(txtCertificateId);
        jFrame1.add(lblFatherName);
        jFrame1.add(txtFatherName);
        jFrame1.add(lblPhoneNumber);
        jFrame1.add(txtPhoneNumber);
        jFrame1.add(lblHomePhone);
        jFrame1.add(txtHomePhone);
        jFrame1.add(lblBirthDate);
        jFrame1.add(cmBoxDay);
        jFrame1.add(cmBoxMonth);
        jFrame1.add(cmBoxYear);
        jFrame1.add(lblAddress);
        jFrame1.add(txtAddress);
        jFrame1.add(lblNationality);
        jFrame1.add(radioBtn1);
        jFrame1.add(radioBtn2);
        jFrame1.add(lblUserType);
        jFrame1.add(cmBoxUserType);
        jFrame1.add(lblInsuranceType);
        jFrame1.add(cmBoxInsuranceType);
        jFrame1.add(lblContractTerm);
        jFrame1.add(spinnerContractTerm);
        jFrame1.add(lblPaymentTrackingCode);
        jFrame1.add(txtPaymentTrackingCode);
        jFrame1.add(lblDocumentNumber);
        jFrame1.add(txtDocumentNumber);
        jFrame1.add(btnRegister);
        jFrame1.add(btnReturn);
        jFrame1.setIconImage(icon.getImage());
        jFrame1.setLocationRelativeTo(null);
        jFrame1.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame1.setLayout(null);
        jFrame1.setVisible(true);
    }

    public void payAnnualPremium() {
        long salary = 10000000;
        jFrame2 = new JFrame("Pay the annual premium");
        jFrame2.setSize(350, 400);
        jFrame2.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.PLAIN, 18);
        ImageIcon icon = new ImageIcon("Icon\\Alborz.jpeg");
        JLabel lblPaymentCode = new JLabel("Payment Code:");
        lblPaymentCode.setBounds(15, 80, 130, 30);
        lblPaymentCode.setFont(font);
        lblPaymentCode.setVisible(true);
        JTextField txtPaymentCode = new JTextField();
        txtPaymentCode.setBounds(140, 85, 180, 25);
        txtPaymentCode.setVisible(true);
        JLabel lblTrackingCode = new JLabel("Tracking Code:");
        lblTrackingCode.setBounds(15, 160, 130, 30);
        lblTrackingCode.setFont(font);
        lblTrackingCode.setVisible(true);
        JTextField txtTrackingCode = new JTextField();
        txtTrackingCode.setBounds(140, 165, 180, 25);
        txtTrackingCode.setVisible(true);
        JButton btnPay = new JButton("Pay");
        btnPay.setBounds(180, 260, 100, 40);
        btnPay.setBackground(Color.DARK_GRAY);
        btnPay.setForeground(Color.WHITE);
        btnPay.setFont(font);
        btnPay.setVisible(true);
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AlborzInsuranceServicesController.getInstance().update(Long.parseLong(txtPaymentCode.getText()), Long.parseLong(txtTrackingCode.getText()), salary);
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
                new AlborzInsuranceServices();
                jFrame2.dispose();
            }
        });
        jFrame2.add(lblPaymentCode);
        jFrame2.add(txtPaymentCode);
        jFrame2.add(lblTrackingCode);
        jFrame2.add(txtTrackingCode);
        jFrame2.add(btnPay);
        jFrame2.add(btnReturn);
        jFrame2.setIconImage(icon.getImage());
        jFrame2.setLocationRelativeTo(null);
        jFrame2.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame2.setLayout(null);
        jFrame2.setVisible(true);
    }

    public void contractInsuranceCancellation() {
        jFrame3 = new JFrame("Cancellation of insurance");
        jFrame3.setSize(350, 300);
        jFrame3.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("TimesRoman", Font.PLAIN, 18);
        ImageIcon icon = new ImageIcon("Icon\\Alborz.jpeg");
        JLabel lblPaymentCode = new JLabel("Payment Code:");
        lblPaymentCode.setBounds(15, 60, 130, 30);
        lblPaymentCode.setFont(font);
        lblPaymentCode.setVisible(true);
        JTextField txtPaymentCode = new JTextField();
        txtPaymentCode.setBounds(140, 65, 180, 25);
        txtPaymentCode.setVisible(true);
        JButton btnCancellation = new JButton("Submit");
        btnCancellation.setBounds(180, 180, 100, 40);
        btnCancellation.setBackground(Color.DARK_GRAY);
        btnCancellation.setForeground(Color.WHITE);
        btnCancellation.setFont(font);
        btnCancellation.setVisible(true);
        btnCancellation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AlborzInsuranceServicesController.getInstance().update(Long.parseLong(txtPaymentCode.getText()));
                } catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton btnReturn = new JButton("Return");
        btnReturn.setBounds(50, 180, 100, 40);
        btnReturn.setBackground(Color.DARK_GRAY);
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(font);
        btnReturn.setVisible(true);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlborzInsuranceServices();
                jFrame3.dispose();
            }
        });
        jFrame3.add(lblPaymentCode);
        jFrame3.add(txtPaymentCode);
        jFrame3.add(btnCancellation);
        jFrame3.add(btnReturn);
        jFrame3.setIconImage(icon.getImage());
        jFrame3.setLocationRelativeTo(null);
        jFrame3.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame3.setLayout(null);
        jFrame3.setVisible(true);
    }
}
