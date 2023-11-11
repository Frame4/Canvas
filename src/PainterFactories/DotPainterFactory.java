package PainterFactories;

import Painters.DotPainter;
import Painters.Painter;

public class DotPainterFactory implements PainterFactory{
    @Override
    public Painter createPainter() {
        return new DotPainter();
    }
}
