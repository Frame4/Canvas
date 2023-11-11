package PainterObserver;

import Painters.Painter;
import java.util.List;
//implementación observer
public class Painting {
    private List<Painter> observers;
    private int currentPainterIndex;

    public Painting(List<Painter> observers) {
        this.observers = observers;
        this.currentPainterIndex = 0;
    }

    public void addObserver(Painter observer) {
        observers.add(observer);
    }

    public void removeObserver(Painter observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        Painter currentPainter = observers.get(currentPainterIndex);
        // Notificar a los observadores sobre la posición, tamaño, color y lados utilizados
        for (Painter painters : observers) {
            painters.update(currentPainter.getPosX(), currentPainter.getPosY(), currentPainter.getSize(), currentPainter.getColor());
        }
    }

    public void paintNext() {
        if (currentPainterIndex < observers.size() - 1) {
            currentPainterIndex++;
        } else {
            currentPainterIndex = 0;
        }
        notifyObservers();
    }
}
