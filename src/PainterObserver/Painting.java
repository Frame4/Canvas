package PaintingPatterns;

import Painters.Painter;
import java.util.List;
//implementación observer
public class Painting {
    private List<Painter> painters;
    private int currentPainterIndex;

    public Painting(List<Painter> painters) {
        this.painters = painters;
        this.currentPainterIndex = 0;
    }

    public void addObserver(Painter painter) {
        painters.add(painter);
    }

    public void removeObserver(Painter painter) {
        painters.remove(painter);
    }

    public void notifyObservers() {
        Painter currentPainter = painters.get(currentPainterIndex);
        // Notificar a los observadores sobre la posición, tamaño, color y lados utilizados
        for (Painter painters : painters) {
            painters.update(currentPainter.getPosition(), currentPainter.getSize(), currentPainter.getColor());
        }
    }

    public void paintNext() {
        if (currentPainterIndex < painters.size() - 1) {
            currentPainterIndex++;
        } else {
            currentPainterIndex = 0;
        }
        notifyObservers();
    }
}
