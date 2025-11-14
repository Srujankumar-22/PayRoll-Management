package com.payroll.ui;

import com.payroll.dao.EmployeeDAO;
import com.payroll.model.Employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeForm extends JFrame {

    private JTextField nameField, roleField, emailField, phoneField;
    private EmployeeDAO empDAO = new EmployeeDAO();

    public EmployeeForm() {
        setTitle("Employee Form");
        setSize(400, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Role:"));
        roleField = new JTextField();
        panel.add(roleField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        panel.add(phoneField);

        JButton saveBtn = new JButton("Save Employee");
        panel.add(saveBtn);

        saveBtn.addActionListener(e -> {
            Employee emp = new Employee();
            emp.setName(nameField.getText());
            emp.setRole(roleField.getText());
            emp.setEmail(emailField.getText());
            emp.setPhone(phoneField.getText());

            if (empDAO.addEmployee(emp)) {
                JOptionPane.showMessageDialog(null, "Employee Added!");
            } else {
                JOptionPane.showMessageDialog(null, "Error adding employee.");
            }
        });

        add(panel);
    }
}
