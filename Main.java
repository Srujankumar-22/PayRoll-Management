package com.payroll;
System.out.print("Designation: "); e.setDesignation(sc.nextLine().trim());
System.out.print("Department: "); e.setDepartment(sc.nextLine().trim());
System.out.print("Basic salary: "); e.setBasicSalary(Double.parseDouble(sc.nextLine().trim()));
int id = employeeDAO.addEmployee(e);
if (id > 0) System.out.println("Employee added with ID: " + id);
else System.out.println("Failed to add employee.");
}


private static void updateEmployee() {
System.out.print("Enter employee id to update: ");
int id = Integer.parseInt(sc.nextLine().trim());
Employee e = employeeDAO.getEmployeeById(id);
if (e == null) { System.out.println("Employee not found"); return; }
System.out.println("Leave blank to keep existing value.");
System.out.print("First name ("+e.getFirstName()+"): "); String s = sc.nextLine(); if (!s.isEmpty()) e.setFirstName(s);
System.out.print("Last name ("+e.getLastName()+"): "); s = sc.nextLine(); if (!s.isEmpty()) e.setLastName(s);
System.out.print("Email ("+e.getEmail()+"): "); s = sc.nextLine(); if (!s.isEmpty()) e.setEmail(s);
System.out.print("Phone ("+e.getPhone()+"): "); s = sc.nextLine(); if (!s.isEmpty()) e.setPhone(s);
System.out.print("Designation ("+e.getDesignation()+"): "); s = sc.nextLine(); if (!s.isEmpty()) e.setDesignation(s);
System.out.print("Department ("+e.getDepartment()+"): "); s = sc.nextLine(); if (!s.isEmpty()) e.setDepartment(s);
System.out.print("Basic salary ("+e.getBasicSalary()+"): "); s = sc.nextLine(); if (!s.isEmpty()) e.setBasicSalary(Double.parseDouble(s));
boolean ok = employeeDAO.updateEmployee(e);
System.out.println(ok ? "Updated." : "Update failed.");
}


private static void deleteEmployee() {
System.out.print("Enter employee id to delete: ");
int id = Integer.parseInt(sc.nextLine().trim());
boolean ok = employeeDAO.deleteEmployee(id);
System.out.println(ok ? "Deleted." : "Delete failed or not found.");
}


private static void listEmployees() {
List<Employee> list = payrollService.listAllEmployees();
if (list.isEmpty()) System.out.println("No employees found.");
else list.forEach(System.out::println);
}


private static void processPayroll() {
try {
System.out.print("Employee id: "); int id = Integer.parseInt(sc.nextLine().trim());
System.out.print("Month (1-12): "); int month = Integer.parseInt(sc.nextLine().trim());
System.out.print("Year (e.g. 2025): "); int year = Integer.parseInt(sc.nextLine().trim());
boolean ok = payrollService.processPayrollForEmployee(id, month, year);
System.out.println(ok ? "Payroll processed and payslip generated." : "Failed: maybe already processed or employee not found.");
} catch (Exception ex) {
System.out.println("Error: " + ex.getMessage());
}
}


private static void viewPayslips() {
System.out.print("Enter employee id to view payslips: ");
int id = Integer.parseInt(sc.nextLine().trim());
List<String> pays = payrollService.getPayslipsForEmployee(id);
if (pays.isEmpty()) System.out.println("No payroll records found.");
else pays.forEach(System.out::println);
}
}