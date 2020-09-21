package ru.geekbrains.java_one.lesson_5;



public class Main {
    public static void main(String[] args) {
//    private static int run=400+(int)(Math.random()*200);
//    private static double bounce=40+(int)(Math.random()*20)*0.01;
//    private static int swimming=8+(int)(Math.random()*4);

        Cat c1=new Cat(",Барсик","Белый",3,
                150+(int)(Math.random()*100),
                (150+(int)(Math.random()*100))*0.01,
                0);
        Dog d1=new Dog(",Шарик","Черный",5,
                400+(int)(Math.random()*200),
                (40+(int)(Math.random()*20))*0.01,
                8+(int)(Math.random()*4));

        System.out.printf("Котик: бег %d, прыжок: %f\n",
                c1.run, c1.bounce );

        System.out.printf("Собака: бег %d, прыжок: %f, плавание: %d\n",
                d1.run, d1.bounce, d1.swimming  );

        System.out.println("Котик "+(c1.run(200)?"пробежал ":"не пробежал"));
        System.out.println("Котик "+(c1.sail(200)?"перепрыгнул ":"не перепрыгнул"));
        System.out.println("Котик "+(c1.jump(200)?"перелыл ":"не перелыл"));

        System.out.println("Собачка "+(d1.run(200)?"пробежал ":"не пробежал"));
        System.out.println("Собачка "+(d1.sail(200)?"перепрыгнул ":"не перепрыгнул"));
        System.out.println("Собачка "+(d1.jump(200)?"перелыл ":"не перелыла"));
    }
}
