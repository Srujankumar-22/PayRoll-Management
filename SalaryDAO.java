package com.payroll.dao;

import com.payroll.model.Salary;
import com.payroll.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO {

    public boolean addSalary(Salary salary) {
        String sql = "INSERT INTO salary (employee_id, basic_salary, hra, allowances, deductions, net_salary, month) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, salary.getEmployeeId());
            ps.setDouble(2, salary.getBasicSalary());
            ps.setDouble(3, salary.getHra());
            ps.setDouble(4, salary.getAllowances());
            ps.setDouble(5, salary.getDeductions());
            ps.setDouble(6, salary.getNetSalary());
            ps.setString(7, salary.getMonth());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Salary> getSalaryByEmployee(int empId) {
        List<Salary> list = new ArrayList<>();
        String sql = "SELECT * FROM salary WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Salary s = new Salary();
                s.setSalaryId(rs.getInt("salary_id"));
                s.setEmployeeId(rs.getInt("employee_id"));
                s.setBasicSalary(rs.getDouble("basic_salary"));
                s.setHra(rs.getDouble("hra"));
                s.setAllowances(rs.getDouble("allowances"));
                s.setDeductions(rs.getDouble("deductions"));
                s.setNetSalary(rs.getDouble("net_salary"));
                s.setMonth(rs.getString("month"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean deleteSalary(int salaryId) {
        String sql = "DELETE FROM salary WHERE salary_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, salaryId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
