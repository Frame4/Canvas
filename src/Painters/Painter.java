package Painters;

public interface Painter {
    public void paint();
    int getPosX();
    int getPosY();
    int getSize();
    int getSides();
    String getColor();
    void update(int posX, int posY, int size, String color);

}
