package CanvasGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CanvasWin extends JFrame {

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

            Graphics2D g2d = (Graphics2D) g;

            // Dibujar un rectángulo azul
            g2d.setColor(new Color(0, 255, 0, 100));

            Rectangle stripe = new Rectangle(0,50,1000,5);
            g2d.fill(stripe);

            AffineTransform rotation = AffineTransform.getRotateInstance(Math.toRadians(45), 0 + 1000 / 2.0, 0 + 50 / 2.0);
            Shape rotatedRectangle = rotation.createTransformedShape(stripe);

            g2d.draw(rotatedRectangle);



            // Dibujar un círculo verde
            g2d.setColor(new Color(0, 153, 0, 20));
            Ellipse2D dot = new Ellipse2D.Double(200, 50, 200, 200);
            g2d.fill(dot);

            // Dibujar un triángulo rojo
            g2d.setColor(new Color(0, 153, 123, 20));
            int[] xPoints = {350, 300, 400};
            int[] yPoints = {50, 150, 150};
            Polygon polygon = new Polygon(xPoints, yPoints, 3);
            g2d.fill(polygon);
        }
    }


    public void PaintPolly(){
        
    }
    public void PaintStripe(){

    }
    public void PaintDot(){

    }



}
