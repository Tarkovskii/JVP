package org.example.factory;

public class Coffee {
    private String name;

    public Coffee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grindCoffee(){
        System.out.println("Перемалываю зерно");
    }

    public void makeCoffee(){
        System.out.println("Делаю кофе");
    }

    public void pourIntoCup(){
        System.out.println("Наливаю в чашку");
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                '}';
    }
}
