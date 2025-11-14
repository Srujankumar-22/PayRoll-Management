package com.payroll.model;

public class Salary {
    private int salaryId;
    private int employeeId;
    private double basicSalary;
    private double hra;
    private double allowances;
    private double deductions;
    private double netSalary;
    private String month;

    public Salary() {}

    public Salary(int salaryId, int employeeId, double basicSalary, double hra,
                  double allowances, double deductions, double netSalary, String month) {
        this.salaryId = salaryId;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = netSalary;
        this.month = month;
    }

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getAllowances() {
        return allowances;
    }

    public void setAllowances(double allowances) {
        this.allowances = allowances;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
