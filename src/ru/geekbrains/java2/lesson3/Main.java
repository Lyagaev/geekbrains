package ru.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        String[] masStih = new String[] {"Тише", "тише", "тише", "тише",
        "Шелестят", "на", "крыше", "мыши",
        "Под", "мышиным", "серым", "флагом",
        "Маршируют", "шаг", "за", "шагом",
        "Впереди", "идут", "старшины",
        "Запевают", "гимн", "мышиный",
        "Тише", "тише", "тише", "тише",
        "Шаг", "ровней", "держите", "мыши",
        "Люди", "сыты", "кошки", "сыты",
        "Для", "мышей", "столы", "накрыты",
        "Затихает", "шорох", "шинный",
        "Наступает", "шаг", "мышиный",
        "Ночью", "пусть" ,"пируют", "мыши",
        "Тише", "тише", "тише", "тише"};

        System.out.println(masWord(masStih));
        System.out.println(masCountWord(masStih));

        PhoneBook phoneBook=new PhoneBook();

        phoneBook.add("Петров","9999999", "1@ua.ru");
        phoneBook.add("Петров","8888888", "2@ua.ru");
        phoneBook.add("Петров","7777777", "3@ua.ru");
        phoneBook.add("Сидоров","11111111", "4@ua.ru");

        System.out.println(phoneBook.searhPhone("Петров"));
        System.out.println(phoneBook.searhEmail("Сидоров"));
    }

    private static HashSet<String> masWord(String[] masStih){
        HashSet<String> set = new HashSet<String>();
        for (int i=0;i<masStih.length;i++)
        {
            set.add(masStih[i]);
        }
        return set;
    }

    private static Map<String, Integer> masCountWord(String[] masStih){
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<masStih.length;i++)
        {
            if (map.containsKey(masStih[i]))
                map.put(masStih[i],(map.get(masStih[i])+1));
            else
                map.put(masStih[i],1);
        }
        return map;
    }



}
