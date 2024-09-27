package org.example.factory;

public class SimpleCoffeeFabric {

    public Coffee orderCoffee(CoffeeType coffeeType){
        Coffee coffee = switch (coffeeType) {
            case ESPRESSO -> new Espresso("Espresso");
            case AMERICANO -> new Americano("Americano");
            case CAPUCCINO -> new Capuccino("Capuccino");
            case CAFFELATTE -> new CaffeLatte("Late");
            default -> throw new IllegalArgumentException("Wrong type");
        };

        return coffee;
    }
}
