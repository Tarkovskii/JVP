package org.example.strategy;

public class Sedan extends Auto{

    public Sedan() {
    this.fillable = new StandartFillStrategy();
    }
}
