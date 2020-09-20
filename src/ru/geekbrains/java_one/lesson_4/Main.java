package ru.geekbrains.java_one.lesson_4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sotrudnik s1= new Sotrudnik("Петров П.В",35500,35);
        System.out.printf("Сотрудник %s, имеет зарпплату: %d\n",
                s1.getFio(),s1.getSalary() );

        Sotrudnik[] arr =  {new Sotrudnik("Петров П.В",35500,35),
                new Sotrudnik("Иванов П.В",40000,45),
                new Sotrudnik("Сидоров П.В",41000,38),
                new Sotrudnik("Васечкин П.В",40000,41),
                new Sotrudnik("Петрушкин П.В",50000,55)};
        System.out.println();

        for (int i=0; i < arr.length; i++)
            if (arr[i].getAge() > 40)
                System.out.printf("Сотрудник %s, имеет зарпплату: %d, и его возраст %d\n",
                        arr[i].getFio(),arr[i].getSalary(),arr[i].getAge() );
        System.out.println();

        increase(arr);
        for (int i=0; i < arr.length; i++)
                System.out.printf("Сотрудник %s, имеет зарпплату: %d, и его возраст %d\n",
                        arr[i].getFio(),arr[i].getSalary(),arr[i].getAge() );
        System.out.println();

        System.out.println("Средняя зп сотрудников "+averageSalary(arr));
        System.out.println("Средний возраст сотрудников "+averageAge(arr));

    }

    public static void increase(Sotrudnik[] arr){
        for (int i=0; i < arr.length; i++)
            if (arr[i].getAge() > 45)
                arr[i].setSalary(arr[i].getSalary()+5000);
    }

    public static double averageAge(Sotrudnik[] arr){
        int Age=0;
        for (int i=0; i < arr.length; i++)
            Age=Age+arr[i].getAge();
        return Age*1.0/arr.length;
    }

    public static double averageSalary(Sotrudnik[] arr){
        int salary=0;
        for (int i=0; i < arr.length; i++)
            salary=salary+arr[i].getSalary();
        return salary*1.0/arr.length;
    }
}
