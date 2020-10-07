package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private MainCircles controller;
    long lastFrameTime;
    private static final int FPS_SLEEP_TIME = 17;

    private float colorR;
    private float colorG;
    private float colorB;

    private float counterR;
    private float counterG;
    private float counterB;

    GameCanvas(MainCircles controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
        colorR=255;
        colorG=255;
        colorB=255;
         counterR=1;
         counterG=1;
         counterB=1;
    }

    @Override
    protected void paintComponent(Graphics g) { // while (true) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(FPS_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long currentTime2 = System.currentTimeMillis();
        setBackground();

        repaint();                              // }
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

    public void setBackground() {

        if ((int)colorR % 255==0){
            counterR =counterR * -1;
            colorR =colorR+counterR;
        }
        else
            colorR =+ colorR+counterR;

        if ((int)colorG % 255==0){
            counterG =counterG * -1;
            colorG=colorG+counterG;
        }
        else
            colorG =+ colorG+counterG*0.1f;

        if ((int)colorB % 255==0){
            counterB = counterB * -1;
            colorB=colorB+counterB;
        }
        else
            colorB =+ colorB+counterB*0.2f;

        System.out.println(colorR+ "    "+colorG+ "    "+colorB+ "    ");
        Color color = new Color(
                (int) colorR, // R
                (int) colorG, // G
                (int) colorB  // B
        );

        setBackground(color);

    }
}