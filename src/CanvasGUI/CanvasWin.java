package CanvasGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CanvasWin extends JFrame {

    private List<Point> points;

    public DibujarFiguras() {
        super("Dibujar Figuras");

        points = new ArrayList<>();

        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Crear el canvas y agregarlo al frame
        Canvas canvas = new Canvas();
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.clear();
                points.add(e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });

        add(canvas);

        // Mostrar el frame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibujar las líneas
        if (points.size() > 1) {
            for (int i = 0; i < points.size() - 1; i++) {
                Point p1 = points.get(i);
                Point p2 = points.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DibujarFiguras());
    }
}
