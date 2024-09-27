package org.example.strategy;

public class StandartFillStrategy implements Fillable{
    @Override
    public void fill() {
        System.out.println("ПРосто заправляем бенз");
    }
}
