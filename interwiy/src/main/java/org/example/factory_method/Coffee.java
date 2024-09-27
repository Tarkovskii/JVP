package org.example.factory_method;

public abstract class Coffee {
    public void makeCoffee(){
        System.out.println("Make coffee");
    }

    public void pourIntoCup(){
        System.out.println("Pour into cup");
    }
}
