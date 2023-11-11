package ObserbablePainters;

import Painters.Painter;
import java.util.List;

public class Painting {
    private List<Painter> painters;
    private int currentPainterIndex;

    public Painting(List<Painter> painters) {
        this.painters = painters;
        this.currentPainterIndex = 0;
    }

    public void addObserver(Painter observer) {
        painters.add(observer);
    }

    public void removeObserver(Painter observer) {
        painters.remove(observer);
    }

    public void notifyObservers() {
        Painter currentPainter = painters.get(currentPainterIndex);
        // Notificar a los observadores sobre la posición, tamaño y color utilizados
        for (Painter observer : painters) {
            observer.update(currentPainter.getPosition(), currentPainter.getSize(), currentPainter.getColor());
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
