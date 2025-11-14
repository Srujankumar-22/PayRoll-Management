package com.payroll.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Payroll Dashboard");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JButton empBtn = new JButton("Employee Management");
        JButton salaryBtn = new JButton("Salary Management");
        JButton attBtn = new JButton("Attendance Management");

        panel.add(empBtn);
        panel.add(salaryBtn);
        panel.add(attBtn);

        empBtn.addActionListener(e -> new EmployeeForm().setVisible(true));
        salaryBtn.addActionListener(e -> new SalaryForm().setVisible(true));
        attBtn.addActionListener(e -> new AttendanceForm().setVisible(true));

        add(panel);
    }
}
