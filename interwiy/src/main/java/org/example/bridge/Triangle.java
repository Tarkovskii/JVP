package org.example.bridge;

public class Triangle extends Shape{

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        color.fillColor();
        System.out.println("drawing triangle");
    }
}
