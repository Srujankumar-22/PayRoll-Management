package com.payroll.dao;

import com.payroll.model.Attendance;
import com.payroll.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public boolean markAttendance(Attendance att) {
        String sql = "INSERT INTO attendance (employee_id, date, status) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, att.getEmployeeId());
            ps.setDate(2, Date.valueOf(att.getDate()));
            ps.setString(3, att.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Attendance> getAttendanceByEmployee(int empId) {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ? ORDER BY date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Attendance a = new Attendance();
                a.setAttendanceId(rs.getInt("attendance_id"));
                a.setEmployeeId(rs.getInt("employee_id"));
                a.setDate(rs.getDate("date").toLocalDate());
                a.setStatus(rs.getString("status"));

                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public boolean deleteAttendance(int attendanceId) {
        String sql = "DELETE FROM attendance WHERE attendance_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, attendanceId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
