package ru.geekbrains.java3.lesson7;

public class Main {

    public static void main(String[] args) {
        try {
            Tester.start(Test1.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}