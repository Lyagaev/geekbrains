package ru.geekbrains.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();


    public float getWeight(){
        float weight = 0.0f;

        for (int i = 0; i < box.size(); i++) {
            weight = weight + box.get(i).getWeight();
        }
        return weight;

    }


    public boolean compare(Box box1) {
        return(getWeight() == box1.getWeight());
    }

    public void pourTo(Box <T>box1){
        box1.box.addAll(box);
        box.clear();
    }


    public void addFruit(T fruit, int count){
        for(int i=0;i<count;i++){
            box.add(fruit);
        }
    }
}