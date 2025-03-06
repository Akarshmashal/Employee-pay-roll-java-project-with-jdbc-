package com.main;

public class Main
{
    public static void main(String[] args) 
    {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Vikaas", 1, 70000.00);
        FullTimeEmployee emp2 = new FullTimeEmployee("Akash",2, 80000.00);
        FullTimeEmployee emp3 = new FullTimeEmployee("sandy", 3, 90000.00);
        PartTimeEmployee emp4 = new PartTimeEmployee(4, "Alex", 40, 100);
        PartTimeEmployee emp5 = new PartTimeEmployee(5, "john", 50, 90);
        PartTimeEmployee emp6 = new PartTimeEmployee(6, "sam", 600, 80);
        

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        

//        System.out.println("\nEmployees in Database:");
//        payrollSystem.displayEmployees();
//
//        System.out.println("\nRemoving Employee with ID 2...");
//        payrollSystem.removeEmployee(2);

        System.out.println("\nRemaining Employees:");
        payrollSystem.displayEmployees();
    }
}

