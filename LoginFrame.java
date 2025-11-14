package com.payroll.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        setTitle("Payroll Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Username:"));
        userField = new JTextField();
        panel.add(userField);

        panel.add(new JLabel("Password:"));
        passField = new JPasswordField();
        panel.add(passField);

        JButton loginBtn = new JButton("Login");
        panel.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = userField.getText();
                String pass = new String(passField.getPassword());

                if (user.equals("admin") && pass.equals("admin")) {
                    new Dashboard().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login!");
                }
            }
        });

        add(panel);
    }
}
