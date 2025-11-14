package com.payroll.ui;

import com.payroll.dao.AttendanceDAO;
import com.payroll.model.Attendance;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class AttendanceForm extends JFrame {

    private JTextField empIdField;
    private JComboBox<String> statusBox;
    private AttendanceDAO attDAO = new AttendanceDAO();

    public AttendanceForm() {
        setTitle("Attendance Form");
        setSize(350, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("Employee ID:"));
        empIdField = new JTextField();
        panel.add(empIdField);

        panel.add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[]{"Present", "Absent", "Leave"});
        panel.add(statusBox);

        JButton markBtn = new JButton("Mark Attendance");
        panel.add(markBtn);

        markBtn.addActionListener(e -> {
            Attendance a = new Attendance();
            a.setEmployeeId(Integer.parseInt(empIdField.getText()));
            a.setDate(LocalDate.now());
            a.setStatus(statusBox.getSelectedItem().toString());

            if (attDAO.markAttendance(a)) {
                JOptionPane.showMessageDialog(null, "Attendance Marked!");
            } else {
                JOptionPane.showMessageDialog(null, "Error marking attendance.");
            }
        });

        add(panel);
    }
}
