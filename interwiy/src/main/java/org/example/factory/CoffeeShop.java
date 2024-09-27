package org.example.factory;

public class CoffeeShop {

    private final SimpleCoffeeFabric coffeeFabric;


    public CoffeeShop(SimpleCoffeeFabric coffeeFabric) {
        this.coffeeFabric = coffeeFabric;
    }

    public Coffee orderCoffee(CoffeeType type){
        Coffee coffee = coffeeFabric.orderCoffee(type);
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();

        System.out.println("Кофе готов, получи!");
        return coffee;
    }
}
