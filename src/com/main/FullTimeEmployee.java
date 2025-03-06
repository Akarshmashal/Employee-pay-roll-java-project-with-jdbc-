package com.main;


public class FullTimeEmployee extends Employee 
{
    private double monthlySalary;

    public FullTimeEmployee(String name, int iD, double monthlySalary)
    {
        super(name, iD);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary()
    {
        return monthlySalary;
    }
}
