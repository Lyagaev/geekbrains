package ru.geekbrains.java_one.lesson_5;

public abstract class Animal {

    protected String name;
    protected String color;
    protected int age;

    protected int run;
    protected double bounce;
    protected int swimming;

    public Animal(String name, String color, int age, int run, double bounce, int swimming) {
        this.age = age;
        this.name = name;
        this.color = color;
        this.run = run;
        this.bounce = bounce;
        this.swimming = swimming;
    }

    //abstract void run();

//    run away
//    sail
//            jump

//Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
//
//У каждого животного есть ограничения на действия
// (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
//При попытке животного выполнить одно из этих действий, оно должно сообщить результат. (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
    boolean run(int length) {
        return  (length<=run);
    }
    boolean sail(int length) {
       return  (length<=bounce);
   }

    boolean jump(int height) {
        return  (height<=swimming);
    }
}
