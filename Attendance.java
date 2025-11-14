package com.payroll.model;

import java.time.LocalDate;

public class Attendance {
    private int attendanceId;
    private int employeeId;
    private LocalDate date;
    private String status; // Present / Absent / Leave

    public Attendance() {}

    public Attendance(int attendanceId, int employeeId, LocalDate date, String status) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
