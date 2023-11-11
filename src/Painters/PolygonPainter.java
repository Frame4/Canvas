package Painters;

import PainterStrategies.PaintingStrategy;

//los que saben pintar polígonos de diversos tamaños y colores
public class PolygonPainter implements Painter {
    private int posX;
    private int posY;
    private int size;
    private int sides;
    private String color;
    private PaintingStrategy paintingStrategy;

    @Override
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPaintingStrategy(PaintingStrategy paintingStrategy) {
        this.paintingStrategy = paintingStrategy;
    }

    @Override
    public void paint() {
        if (paintingStrategy != null) {
            paintingStrategy.executePainting();
        }
    }

    @Override
    public void update(int posX, int posY, int size, String color) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.color = color;
    }
}
