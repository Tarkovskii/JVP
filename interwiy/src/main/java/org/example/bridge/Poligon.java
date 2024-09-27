package org.example.bridge;

public class Poligon {
    public static void main(String[] args) {
        Color red = new RedColor();
        Shape triangle = new Triangle(red);

        triangle.draw();
    }
}
