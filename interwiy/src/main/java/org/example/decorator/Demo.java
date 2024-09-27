package org.example.decorator;

public class Demo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape readCircle = new RedDecoratorShape(new Circle());

        circle.draw();

        readCircle.draw();
    }
}
