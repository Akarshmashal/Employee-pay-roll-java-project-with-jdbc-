package com.main;

import java.util.ArrayList;


abstract public class Employee 
{
    private String name;
    private int Id;

    public Employee(String name, int iD) 
    {
        this.name = name;
        this.Id = iD;
    }

    public String getName() 
    {
        return name;
    }

    public int getId()
    {
        return Id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() 
    {
        return "Employee [name=" + name + ", Id=" + Id + ", Salary=" + calculateSalary() + "]";
    }
}