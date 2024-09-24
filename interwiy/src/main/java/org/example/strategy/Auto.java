package org.example.strategy;

public class Auto {

    Fillable fillable; //Поле объекта-стратегии (нет реализации просто интерфейс) Реализация в дочернихх классах

    public void gas(){
        System.out.println("Move forward");
    }

    public void stop(){
        System.out.println("We stop");
    }

    public void fill(){
        fillable.fill();
    }

}
