package org.example.strategy;

public class FqCar extends Auto{

    public FqCar() {
        this.fillable = new F1PitStopStrategy();
        //реализация объекта стратегии в классе
    }
}
