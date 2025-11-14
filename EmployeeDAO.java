package com.payroll.dao;
}
return false;
}


public Employee getEmployeeById(int empId) {
String sql = "SELECT * FROM employees WHERE emp_id=?";
try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setInt(1, empId);
try (ResultSet rs = ps.executeQuery()) {
if (rs.next()) {
return mapRow(rs);
}
}
} catch (SQLException e) {
e.printStackTrace();
}
return null;
}


public List<Employee> getAllEmployees() {
List<Employee> list = new ArrayList<>();
String sql = "SELECT * FROM employees ORDER BY emp_id";
try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
while (rs.next()) list.add(mapRow(rs));
} catch (SQLException e) {
e.printStackTrace();
}
return list;
}


private Employee mapRow(ResultSet rs) throws SQLException {
Employee e = new Employee();
e.setEmpId(rs.getInt("emp_id"));
e.setFirstName(rs.getString("first_name"));
e.setLastName(rs.getString("last_name"));
e.setEmail(rs.getString("email"));
e.setPhone(rs.getString("phone"));
e.setDesignation(rs.getString("designation"));
e.setDepartment(rs.getString("department"));
e.setBasicSalary(rs.getDouble("basic_salary"));
return e;
}
}