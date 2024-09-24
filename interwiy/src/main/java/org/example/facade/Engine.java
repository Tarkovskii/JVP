package org.example.facade;

public class Engine implements Car{
    @Override
    public void start() {
        System.out.println("Start engine");
    }

    @Override
    public void stop() {
        System.out.println("Stop engine");
    }
}
