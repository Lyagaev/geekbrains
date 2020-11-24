package ru.geekbrains.java3.lesson4;

public class MFU {
    //2. Создать модель MFU (c возможность сканирования, печати и ксерокопии)
    public static void main(String[] args) {
        final Object print = new Object();
        final Object scan = new Object();


        Thread печать = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (print) {
                    System.out.println("Чел1 начал печать");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел1 закончил печать");
                }
            }
        });


        Thread сканирование = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (scan) {
                    System.out.println("Чел2 начал сканирование");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Чел2 закончил сканирование");
                }
            }
        });


        Thread ксерокопия = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (print)
                {
                    synchronized (scan)
                    {
                        System.out.println("Чел3 начал делать ксерокопию");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Чел3 закончил делать ксерокопию");
                    }
                }
            }
        });


//        ксерокопия.start();
//        печать.start();
//        сканирование.start();

        печать.start();
        сканирование.start();
        ксерокопия.start();
    }
}
