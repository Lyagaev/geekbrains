package ru.geekbrains.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String myArr[]={"1","2","3","4","5"};
        moveItems(myArr,0,4);

        toArList(myArr);

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        orangeBox1.addFruit(new Orange(1.5f),10);
        orangeBox2.addFruit(new Orange(1.5f),12);
        appleBox1.addFruit(new Apple(1f),8);
        appleBox2.addFruit(new Apple(1f),4);


        System.out.println("Box 1: "+orangeBox1.getWeight());
        System.out.println("Box 2: "+orangeBox2.getWeight());
        System.out.println("Box 3: "+appleBox1.getWeight());
        System.out.println("Box 4: "+appleBox2.getWeight());



        System.out.println("Box 1 equals box 3: "+orangeBox1.compare(appleBox1));
        System.out.println("Box 2 equals box 4: "+orangeBox2.compare(appleBox2));



        orangeBox1.pourTo(orangeBox2);
        appleBox1.pourTo(appleBox2);
        System.out.println("Box 1: "+orangeBox1.getWeight());
        System.out.println("Box 2: "+orangeBox2.getWeight());
        System.out.println("Box 3: "+appleBox1.getWeight());
        System.out.println("Box 4: "+appleBox2.getWeight());
    }

    public static void moveItems(Object[] myArr, int num1, int num2){
        System.out.println("Массив: "+ Arrays.toString(myArr));
        Object arrN1 = myArr[num1];
        myArr[num1]=myArr[num2];
        myArr[num2]=arrN1;
        System.out.println("Результат после замены: "+Arrays.toString(myArr));
    }

    public static <T> void toArList(T[]myArr){
        ArrayList<T> myArrList = new ArrayList<>(Arrays.asList(myArr));
    }
}
