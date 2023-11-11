package ObserbablePainters;


import Painters.Painter;

public interface PaintingIterator {
    boolean hasNext();
    Painter next();
}
