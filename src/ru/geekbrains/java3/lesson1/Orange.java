package ru.geekbrains.java3.lesson1;

public class Orange extends Fruit {
    private float weight;

    Orange(float weight){
        this.weight=weight;
    }

    @Override
    float getWeight() {
        return weight;
    }

}
