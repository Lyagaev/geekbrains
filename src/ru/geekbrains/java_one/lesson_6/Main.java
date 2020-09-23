package ru.geekbrains.java_one.lesson_6;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main (String[] args){
       String[] path1= {"test1.txt","test2.txt"};

        try {
            FileOutputStream fOut1=new FileOutputStream(path1[0]);
            fOut1.write("first part of the text".getBytes());
            fOut1.close();
            FileOutputStream fOut2=new FileOutputStream(path1[1]);
            fOut2.write("second part of the text".getBytes());
            fOut2.close();
        }
        catch (IOException ex){
            System.out.println((ex.getMessage()));
        }


        try {
            Scanner scanner = new Scanner(new FileInputStream(allyFile(path1)));
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("В файле test1.txt "+(searchFile("test1.txt","the")?"слово the найдено":"слово the не найдено"));

        System.out.println("В папке test "+(searchFolder("C:\\Users\\User\\IdeaProjects\\geekbrains\\test","second")?"слово second найдено":"слово second не найдено"));
    }

    private static String allyFile(String[] path){
        String pathRes="result.txt";
        StringBuilder text=new StringBuilder("");
        try {
        for (int i=0;i<path.length;i++)
        {

            Scanner scanner = new Scanner(new FileInputStream(path[i]));
            while (scanner.hasNext()){
                 text.append(scanner.nextLine());
            }
            text.append("\n");
        }
            FileOutputStream fOut=new FileOutputStream(pathRes);
            fOut.write(text.toString().getBytes());
            fOut.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        return pathRes;
    }

    private static boolean searchFile(String path, String word){
        StringBuilder text=new StringBuilder("");
        try {
            Scanner scanner = new Scanner(new FileInputStream(path));
            while (scanner.hasNext()){
                if (word.equals(scanner.next()))
                {
                    return true;
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    private static boolean searchFolder(String path, String word){
        try {
            File dir = new File(path.toString());
            File[] lFile= dir.listFiles();
            for(int i=0; i<lFile.length;i++){
                if (searchFile(lFile[i].toPath().toString(),word))
                    return true;
            }
            return false;
        }
        catch (Exception ex){

        }
        return false;
    }
}
