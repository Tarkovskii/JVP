package org.example.factory_method;

public abstract class CoffeeShop {

    public Coffee orderCoffee(CoffeeType type){
        Coffee coffee = createCoffee(type);

        coffee.makeCoffee();
        coffee.pourIntoCup();
        System.out.println("Coffee done. Take this");
        return coffee;
    }

    protected abstract Coffee createCoffee(CoffeeType type);
}
