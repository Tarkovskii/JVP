package org.example.strategy;

public class HybridFillStrategy implements Fillable{
    @Override
    public void fill() {
        System.out.println("Запрвка бензом или электр");
    }
}
