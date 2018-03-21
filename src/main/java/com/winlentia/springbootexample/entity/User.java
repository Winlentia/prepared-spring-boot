package com.winlentia.springbootexample.entity;

public class User
{
    private long id;
    private String name;
    private int age;
    private double salary;

    public User (){
        id = 0;
    }

    public User(long id, String name, int age, double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
