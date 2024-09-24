package org.example.bridge;

public abstract class Shape {
    public Shape(Color color) {
        this.color = color;
    }

    protected Color color;
    public abstract void draw();
}
