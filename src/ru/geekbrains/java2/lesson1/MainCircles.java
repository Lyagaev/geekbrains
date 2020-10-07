package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;


    Sprite[] sprites = new Sprite[10];
    private static Sprite[] sprites2;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });


    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);

        sprites2=new Sprite[sprites.length];

        canvas.addMouseListener(new MouseListener() {  // отслеживаем действие кнопки мыши


                                    @Override
                                    public void mouseClicked(MouseEvent e) {

                                        if (e.getButton()==1)
                                        {
                                            Sprite[] sprites3 = new Sprite[sprites2.length];
                                            System.arraycopy(sprites2, 0, sprites3, 0, sprites2.length);
                                            sprites2=new Sprite[sprites2.length+1];
                                            System.arraycopy(sprites3, 0, sprites2, 0, sprites3.length);
                                            sprites2[sprites3.length] = new Ball();
                                        }
                                        if (e.getButton()==3)
                                        {
                                            if (sprites2.length>1)
                                            {
                                                Sprite[] sprites3 = new Sprite[sprites2.length];
                                                System.arraycopy(sprites2, 0, sprites3, 0, sprites2.length);
                                                sprites2=new Sprite[sprites2.length-1];
                                                System.arraycopy(sprites3, 0, sprites2, 0, sprites3.length-1);
                                            }
                                        }
                                    }

                                    @Override
                                    public void mousePressed(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseReleased(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {

                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {

                                    }
                                });


            add(canvas);
            initApplication();
            System.arraycopy(sprites2, 0, sprites, 0, sprites2.length);

        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites2.length; i++) {
            sprites2[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);

    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites2.length; i++) {
            sprites2[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites2.length; i++) {
            sprites2[i].render(canvas, g);
        }
    }



}
