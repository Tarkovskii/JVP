package org.example.factory;

public class Skuratov {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop(new SimpleCoffeeFabric());
        System.out.println(coffeeShop.orderCoffee(CoffeeType.CAFFELATTE));

        System.out.println(coffeeShop.orderCoffee(CoffeeType.AMERICANO));

    }
}
