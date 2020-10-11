package ru.geekbrains.java2.lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String [][] strMas=metod1("10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0");
        Float res= metod2(strMas);
        System.out.println(res);
    }


    private static String[][] metod1(String line) throws Exception{
        String[] strArr = line.split("\n");
        if (strArr.length != 4)
            throw new Exception("Количество строк в матрице не равно 4");

        String[][] strMas = {
                strArr[0].split(" "),
                strArr[1].split(" "),
                strArr[2].split(" "),
                strArr[3].split(" "),
        };
        for (int i=0; i<strMas.length;i++)
           if (strMas[i].length!=4)
               throw new Exception("В строке "+ (i+1) +" количество элементов не равно 4");

        return strMas;
    }

    private static float metod2(String[][] strMas) throws Exception {
        Integer[][] intMas=new Integer[strMas.length][strMas[0].length];
        Integer sum=0;
        for (int i=0; i<strMas.length;i++)
            for (int j=0; j<strMas[i].length;j++)
            {
                Integer resInt=0;
                try {
                    resInt=Integer.parseInt(strMas[i][j]);
                } catch (NumberFormatException e) {
                    throw new Exception("В матрице, в строке "+ i +" столбце "+ j +" не число");
                }
                sum=sum+resInt;
                intMas[i][j] = resInt;
            }

        return sum/2;
    }

}
