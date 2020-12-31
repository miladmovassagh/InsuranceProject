package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainInsurance {
    private JFrame jFrame;

    public MainInsurance() {
        jFrame = new JFrame("Insurance Application");
        jFrame.setSize(450, 500);
        jFrame.getContentPane().setBackground(Color.WHITE);
        BufferedImage image = null;
        Image image1;
        ImageIcon imageIcon;
        JButton btnIran = new JButton();
        try {
            image = ImageIO.read(new File("Icon\\Iran.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        image1 = image.getScaledInstance(240, 160, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        btnIran.setIcon(imageIcon);
        btnIran.setBackground(Color.WHITE);
        btnIran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IranInsurance();
                jFrame.dispose();
            }
        });
        JButton btnAlborz = new JButton();
        try {
            image = ImageIO.read(new File("Icon\\Alborz.jpeg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        image1 = image.getScaledInstance(230, 155, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        btnAlborz.setIcon(imageIcon);
        btnAlborz.setBackground(Color.WHITE);
        btnAlborz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlborzInsurance();
                jFrame.dispose();
            }
        });
        JButton btnPasargad = new JButton();
        try {
            image = ImageIO.read(new File("Icon\\Pasargad.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        image1 = image.getScaledInstance(280, 160, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        btnPasargad.setIcon(imageIcon);
        btnPasargad.setBackground(Color.WHITE);
        btnPasargad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PasargadInsurance();
                jFrame.dispose();
            }
        });
        JButton btnParsian = new JButton();
        try {
            image = ImageIO.read(new File("Icon\\Parsian.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        image1 = image.getScaledInstance(240, 160, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        btnParsian.setIcon(imageIcon);
        btnParsian.setBackground(Color.WHITE);
        btnParsian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ParsianInsurance();
                jFrame.dispose();
            }
        });
        JButton btnKosar = new JButton();
        try {
            image = ImageIO.read(new File("Icon\\Kosar.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        image1 = image.getScaledInstance(240, 160, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        btnKosar.setIcon(imageIcon);
        btnKosar.setBackground(Color.WHITE);
        btnKosar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KosarInsurance();
                jFrame.dispose();
            }
        });
        JButton btnSocialSupply = new JButton();
        try {
            image = ImageIO.read(new File("Icon\\Social Supply.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        image1 = image.getScaledInstance(240, 160, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image1);
        btnSocialSupply.setIcon(imageIcon);
        btnSocialSupply.setBackground(Color.WHITE);
        btnSocialSupply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SocialSupplyInsurance();
                jFrame.dispose();
            }
        });
        imageIcon = new ImageIcon("Icon\\Insurance.png");
        jFrame.add(btnIran);
        jFrame.add(btnAlborz);
        jFrame.add(btnPasargad);
        jFrame.add(btnParsian);
        jFrame.add(btnKosar);
        jFrame.add(btnSocialSupply);
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(3,2));
        jFrame.setVisible(true);
    }
}