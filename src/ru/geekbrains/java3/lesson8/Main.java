package ru.geekbrains.java3.lesson8;

public class Main {
    public static void main(String[] args) {
        int[][] arr=new int[5][8];
        metod1(arr);


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }


    }


    private static void metod1(int[][] arr){
        int round;                  //число оборотов
        int count=1;                //числа по порядку
        int countEnd=0;              //максимальное число в текущем обороте
        int maxNumRoun=0;
        int col=0;
        int rowStart=0;
        int rowEnd=arr.length;
        int colStart=0;
        int colEnd=arr[0].length;

        int tempNum=0;

        //считаем число оборотов
        if (arr[0].length<=arr.length)
        {
            round=arr[0].length;
        }else
        {
            round=arr.length;
        }

        for (int put=0;put<round/2+1;put++){
            maxNumRoun=maxNumRoun+col;
            //считаем сумму элементов боковых сторон
            col=0;
            if (put==round/2)
            {
                col=(arr[0].length-(2*put));
            }else
            {
                col=(arr[0].length-(2*put))*2+(arr.length-2-(2*put))*2;
            }
            count=maxNumRoun;
            countEnd=count+col;

            for (int i=rowStart; i< rowEnd; i++) {
                for (int j = colStart; j <colEnd; j++) {

                    boolean chek=false;         //признак того что надо прибавить к count+1
                    if (i==rowStart){
                        arr[i][j] = count+1;    //так как счет начинается с 0 то прибовляем +1
                        chek=true;
                    }else if (i==rowEnd-1){
                        arr[i][j] = countEnd;   //если это последняя строка то записываем в Ячейку countEnd и вычитаем-1 из нее
                        countEnd=countEnd-1;
                        chek=true;
                    }else
                    {
                        if(j==colStart)
                        {
                            arr[i][j] = countEnd;   //если это первый столбец и не первая строка то записываем в Ячейку countEnd и вычитаем-1 из нее
                            countEnd=countEnd-1;
                        }
                        if(j==colEnd-1)
                        {
                            arr[i][j] = count+1;    //если это последний столбец то записываем в ячейку count, так как счет начинается с 0 то прибовляем +1
                            chek=true;
                        }
                    }

                    if (chek)
                    {
                        count = count+1;
                    }
                }
            }

            rowStart=rowStart+1;
            colStart=colStart+1;
            rowEnd=rowEnd-1;
            colEnd=colEnd-1;

        }







    }
}
