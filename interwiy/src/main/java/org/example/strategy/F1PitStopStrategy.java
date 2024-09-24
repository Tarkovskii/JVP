package org.example.strategy;

public class F1PitStopStrategy implements Fillable{
    @Override
    public void fill() {
        System.out.println("Заправляем бенз только поосле всех процедур");
    }
}
