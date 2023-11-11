import CanvasGUI.CanvasWin;
import PainterFactories.*;
import PainterIterator.*;
import Painters.Painter;

import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PainterFactory dotPainterFactory = new DotPainterFactory();
        PainterFactory stripePainterFactory = new StripePainterFactory();
        PainterFactory polygonPainterFactory = new PolygonPainterFactory();


        List<Painter> painters = new ArrayList<>();
        painters.add(dotPainterFactory.createPainter());
        painters.add(stripePainterFactory.createPainter());
        painters.add(polygonPainterFactory.createPainter());

        PaintingIterator iterator = new IteratorImplementation(painters);

        while(iterator.hasNext()){
            Painter painter = iterator.next();


        }

        SwingUtilities.invokeLater(() -> {
            CanvasWin viewer = new CanvasWin();
            viewer.setVisible(true);
        });

    }
}