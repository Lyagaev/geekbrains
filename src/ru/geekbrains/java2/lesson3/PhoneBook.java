package ru.geekbrains.java2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, ArrayList<Person>> map = new HashMap<>();

    public Map<String, ArrayList<Person>> add(String surname, String phone, String email)
    {
        Person person=new Person(phone, email);
        ArrayList<Person> arrPerson = new ArrayList<>();
        if (map.containsKey(surname))
        {
            arrPerson = (ArrayList) map.get(surname).clone();
        }
            arrPerson.add(person);

        map.put(surname,arrPerson);
        return map;
    }

    public ArrayList<String> searhPhone(String surname){
        ArrayList<String> arrayList=new ArrayList<>();

        ArrayList<Person> arrayList2=map.get(surname);
        for (int i=0;i<arrayList2.size();i++)
        {
            arrayList.add(arrayList2.get(i).phone);
        }
        return arrayList;
    }

    public ArrayList<String> searhEmail(String surname){
        ArrayList<String> arrayList=new ArrayList<>();

        ArrayList<Person> arrayList2=map.get(surname);
        for (int i=0;i<arrayList2.size();i++)
        {
            arrayList.add(arrayList2.get(i).email);
        }
        return arrayList;
    }

}
