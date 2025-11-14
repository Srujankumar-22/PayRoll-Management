package com.payroll.ui;

import com.payroll.dao.SalaryDAO;
import com.payroll.model.Salary;

import javax.swing.*;
import java.awt.*;

public class SalaryForm extends JFrame {

    private JTextField empIdField, basicField, hraField, alloField, dedField, monthField;
    private SalaryDAO salaryDAO = new SalaryDAO();

    public SalaryForm() {
        setTitle("Salary Form");
        setSize(450, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Employee ID:"));
        empIdField = new JTextField();
        panel.add(empIdField);

        panel.add(new JLabel("Basic Salary:"));
        basicField = new JTextField();
        panel.add(basicField);

        panel.add(new JLabel("HRA:"));
        hraField = new JTextField();
        panel.add(hraField);

        panel.add(new JLabel("Allowances:"));
        alloField = new JTextField();
        panel.add(alloField);

        panel.add(new JLabel("Deductions:"));
        dedField = new JTextField();
        panel.add(dedField);

        panel.add(new JLabel("Month:"));
        monthField = new JTextField();
        panel.add(monthField);

        JButton calculateBtn = new JButton("Calculate & Save");
        panel.add(calculateBtn);

        calculateBtn.addActionListener(e -> {
            Salary s = new Salary();
            s.setEmployeeId(Integer.parseInt(empIdField.getText()));
            s.setBasicSalary(Double.parseDouble(basicField.getText()));
            s.setHra(Double.parseDouble(hraField.getText()));
            s.setAllowances(Double.parseDouble(alloField.getText()));
            s.setDeductions(Double.parseDouble(dedField.getText()));

            double net = s.getBasicSalary() + s.getHra() + s.getAllowances() - s.getDeductions();
            s.setNetSalary(net);

            s.setMonth(monthField.getText());

            if (salaryDAO.addSalary(s)) {
                JOptionPane.showMessageDialog(null, "Salary Saved! Net Salary = " + net);
            } else {
                JOptionPane.showMessageDialog(null, "Error saving salary.");
            }
        });

        add(panel);
    }
}
