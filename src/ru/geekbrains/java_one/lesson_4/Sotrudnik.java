package ru.geekbrains.java_one.lesson_4;

public class Sotrudnik {
    private static int count=1;
    private int Id;
    private String Fio;
    private int Salary;
    private int Age;

    public Sotrudnik(String fio, int salary, int age) {
        this.Fio = fio;
        this.Salary = salary;
        this.Age = age;
        this.Id=this.count;
        this.count=this.count+1;
    }

    public int getId() {
        return Id;
    }

    public String getFio() {
        return Fio;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        this.Salary = salary;
    }

    public int getAge() {
        return Age;
    }
}
