package CanvasGUI;

import Painters.*;
import Painters.Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class CanvasWin extends JFrame {
    Random random = new Random();
    static Graphics2D canvas;

    public CanvasWin() {
        setTitle("Arte Abstracto");
        setSize(650, 650);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        add(canvas);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }


    private static class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            canvas = (Graphics2D) g;

            // Dibujar un rectángulo azul
            canvas.setColor(new Color(0, 255, 0, 100));

            Rectangle stripe = new Rectangle(0,50,1000,5);
            canvas.fill(stripe);

            AffineTransform rotation = AffineTransform.getRotateInstance(Math.toRadians(45), 0 + 1000 / 2.0, 0 + 50 / 2.0);
            Shape rotatedRectangle = rotation.createTransformedShape(stripe);

            canvas.fill(rotatedRectangle);



            // Dibujar un círculo verde
            canvas.setColor(new Color(0, 153, 0, 20));
            Ellipse2D dot = new Ellipse2D.Double(200, 50, 200, 200);
            canvas.fill(dot);

            // Dibujar un triángulo rojo
            canvas.setColor(new Color(0, 153, 123, 20));
            int[] xPoints = {60, 150, 100,40,60,60};
            int[] yPoints = {50, 500, 100,500,100,200};
            Polygon polygon = new Polygon(xPoints, yPoints, 4);
            canvas.fill(polygon);
        }
    }


    public void PaintPolly(Painter painter){
        int sides = painter.getSides();
        int[] xPos = new int[sides];
        int[] yPos = new int[sides];
        switch (painter.getSize()){
            case 1:
                for(int i = 0; i<sides; i++){
                    xPos[i] = random.nextInt(101) + 50;
                    yPos[i] = random.nextInt(101) + 50;
                }
                break;
            case 2:
                for(int i = 0; i<sides; i++){
                    xPos[i] = random.nextInt(201) + 150;
                    yPos[i] = random.nextInt(201) + 150;
                }
                break;
            case 3:
                for(int i = 0; i<sides; i++){
                    xPos[i] = random.nextInt(251) + 350;
                    yPos[i] = random.nextInt(251) + 350;
                }
        }
        Polygon polygon = new Polygon(xPos, yPos, sides);
        int rgbValue = Integer.parseInt(painter.getColor(), 16);
        canvas.setColor(new Color(rgbValue));
        canvas.fill(polygon);

    }
    public void PaintStripe(Painter painter){
        Rectangle stripe = new Rectangle(painter.getPosX(),painter.getPosY(),1000,painter.getSize());
        int rgbValue = Integer.parseInt(painter.getColor(), 16);
        canvas.setColor(new Color(rgbValue));
        canvas.fill(stripe);
    }
    public void PaintDot(Painter painter){
        Ellipse2D dot = new Ellipse2D.Double(painter.getPosX(), painter.getPosY(), painter.getSize(), painter.getSize());
        int rgbValue = Integer.parseInt(painter.getColor(), 16);
        canvas.setColor(new Color(rgbValue));
        canvas.fill(dot);
    }



}
