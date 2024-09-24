package org.example.bridge;

public class Rectangle extends Shape{

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        color.fillColor();
        System.out.println("drawing rectangle");
    }
}
