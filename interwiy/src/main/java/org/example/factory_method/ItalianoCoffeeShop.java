package org.example.factory_method;

import org.example.factory.Americano;
import org.example.factory.CaffeLatte;
import org.example.factory.Capuccino;
import org.example.factory.Espresso;

public class ItalianoCoffeeShop extends CoffeeShop{
    @Override
    protected Coffee createCoffee(CoffeeType type) {
        Coffee coffee = switch (type){
        case ESPRESSO -> new ItalianoStyleExpresso();
        case AMERICANO -> new ItalianoStyleAmericano();
        case CAPUCCINO -> new ItalianoStyleCapuccino();
        case COFFEELATTE -> new ItalianoStyleCoffeeLatte();
        default -> throw new IllegalArgumentException("Wrong type");
    };

        return coffee;
    }
}
