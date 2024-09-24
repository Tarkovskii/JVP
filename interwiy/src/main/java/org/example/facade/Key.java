package org.example.facade;

public class Key implements Car{
    @Override
    public void start() {
        System.out.println("Input key");
    }

    @Override
    public void stop() {
        System.out.println("output key");
    }
}
