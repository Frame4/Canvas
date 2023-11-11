package PainterFactories;

import Painters.Painter;
import Painters.StripePainter;

public class StripePainterFactory implements PainterFactory{
    @Override
    public Painter createPainter() {
        return new StripePainter();
    }
}
