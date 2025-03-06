package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        this.employeeList = new ArrayList<>();
    }

    // Add Employee to Database
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employees (Id, Name, Type, Salary, HoursWorked, HourlyRate) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());

            if (employee instanceof FullTimeEmployee) {
                pstmt.setString(3, "FullTime");
                pstmt.setDouble(4, employee.calculateSalary());
                pstmt.setNull(5, java.sql.Types.INTEGER);
                pstmt.setNull(6, java.sql.Types.DOUBLE);
            } else if (employee instanceof PartTimeEmployee) {
                PartTimeEmployee pt = (PartTimeEmployee) employee;
                pstmt.setString(3, "PartTime");
                pstmt.setDouble(4, pt.calculateSalary());
                pstmt.setInt(5, pt.getHoursWorked());
                pstmt.setDouble(6, pt.getHourlyRate());
            }

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully!");
            }

        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    // Remove Employee from Database
    public void removeEmployee(int id) {
        String query = "DELETE FROM Employees WHERE Id = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Employee removed successfully!");
            } else {
                System.out.println("No employee found with ID: " + id);
            }

        } catch (SQLException e) {
            System.err.println("Error removing employee: " + e.getMessage());
        }
    }

    // Display Employees from Database
    public void displayEmployees() {
        String query = "SELECT * FROM Employees";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                String type = rs.getString("Type");
                double salary = rs.getDouble("Salary");

                System.out.println("Employee [ID=" + id + ", Name=" + name + ", Type=" + type + ", Salary=" + salary + "]");
            }

        } catch (SQLException e) {
            System.err.println("Error displaying employees: " + e.getMessage());
        }
    }
}
