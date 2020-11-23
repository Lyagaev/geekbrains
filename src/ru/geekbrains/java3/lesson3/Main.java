package ru.geekbrains.java3.lesson3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        //One();
        //taskTwo();
        Three();
        System.out.println(System.currentTimeMillis() - t);
    }


    private static void One() {
        File fiftyBytes = new File("1.txt");
        File fileWithArray = new File("1.txt");
        byte[] array = readAFileToByteArray(fiftyBytes);
        System.out.println(Arrays.toString(array));
        arrayToFile(fileWithArray, array); //check my array
    }

    public static void arrayToFile(File file, byte[] array) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(array);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readAFileToByteArray(File file) {
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                byteArrayOutputStream.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();

    }

    private static void taskTwo() {
        try {
            File result = joinAllFilesIntoOne(new File("1.txt"), new File("2.txt"),
                    new File("3.txt"), new File("4.txt"), new File("5.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File joinAllFilesIntoOne(File... files) throws IOException {
        ArrayList<InputStream> arrayList = new ArrayList<>();
        File allFilesInOne = new File("allFilesInOne.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(allFilesInOne);
        for (File f : files) {
            arrayList.add(new FileInputStream(f));
        }
        Enumeration<InputStream> en = Collections.enumeration(arrayList);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(en);
        int temp = 0;
        while ((temp = sequenceInputStream.read()) != -1) {
            fileOutputStream.write(temp);
        }
        return allFilesInOne;
    }



    private static void Three(){
        try {
            final int PAGE_SIZE = 1800;
            RandomAccessFile raf = new RandomAccessFile("allFilesInOne.txt", "rw");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter page:");
            int p = sc.nextInt() - 1;
            raf.seek(p * PAGE_SIZE);

            /* Инициализация буфера */
            byte[] buffer = new byte[PAGE_SIZE];

            /* Чтение в byte[]-буфер */
            raf.read(buffer);

            /* Преобразуем byte[]-буфер в строку символов UFT-8 для вывода на экран */
            System.out.println(new String(buffer, "UTF-8"));
            raf.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }



}
