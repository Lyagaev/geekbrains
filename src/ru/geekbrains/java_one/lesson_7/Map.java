package ru.geekbrains.java_one.lesson_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;


    public Map() {
        setBackground(new Color(0x0a, 0x4f, 0xb0)); // r g b //#0a4fb0

    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode:%d, size:%d, win:%d\n", gameMode, fieldSizeX, winLength);

    }
}