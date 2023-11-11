package PainterFactories;

import Painters.Painter;
import Painters.PolygonPainter;

public class PolygonPainterFactory implements PainterFactory{
    @Override
    public Painter createPainter() {
        return new PolygonPainter();
    }
}
