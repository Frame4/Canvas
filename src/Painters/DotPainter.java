package Painters;

import PainterStrategies.PaintingStrategy;

//los que saben pintar lunares de colores de diversos tamaños
public class DotPainter implements Painter {
    private int posX;
    private int posY;
    private int size;
    private String color;

    private PaintingStrategy paintingStrategy;


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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSides() {
        return 1;
    }

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
