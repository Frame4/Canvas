package PainterIterator;

import Painters.Painter;
import java.util.List;

public class IteratorImplementation implements PaintingIterator {
    private List<Painter> painters;
    private int currentIndex;

    public IteratorImplementation(List<Painter> painters) {
        this.painters = painters;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < painters.size();
    }

    @Override
    public Painter next() {
        if (hasNext()) {
            Painter painter = painters.get(currentIndex);
            currentIndex++;
            return painter;
        } else {
            return null; // O lanzar una excepción, dependiendo de los requisitos.
        }
    }
}
