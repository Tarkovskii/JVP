package org.example.factory_method;

public class Surfe {
    public static void main(String[] args) {
        CoffeeShop italiCoffeeShop = new ItalianoCoffeeShop();
        italiCoffeeShop.orderCoffee(CoffeeType.CAPUCCINO);

        CoffeeShop americanoCoffeeShop = new AmericanoCoffeeShop();
        americanoCoffeeShop.orderCoffee(CoffeeType.ESPRESSO);

    }
}
