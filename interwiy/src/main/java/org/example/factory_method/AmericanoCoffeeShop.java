package org.example.factory_method;

public class AmericanoCoffeeShop extends CoffeeShop {
    @Override
    protected Coffee createCoffee(CoffeeType type) {
        Coffee coffee = switch (type) {
            case ESPRESSO -> new AmericanoStyleEspresso();
            case AMERICANO -> new AmericanoStyleAmericano();
            case CAPUCCINO -> new AmericanoStyleCapuccino();
            case COFFEELATTE -> new AmericanoStyleCoffeeLatte();
            default -> throw new IllegalArgumentException("Wrong type");
        };

        return coffee;
    }
}
