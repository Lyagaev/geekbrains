package ru.geekbrains.java3.lesson1;

public class Apple extends Fruit {

    private float weight;


    Apple(float weight){
        this.weight=weight;
    }

    @Override
    float getWeight() {
        return weight;
    }



}
