package org.example.chain_of_responsibility;

public class DemoChain {
    public static void main(String[] args) {
        Handler handler = new Repeater();
        Taxi taxi = new Taxi("777");

        handler.bind(new Taxi("123"))
                .bind(new Taxi("456"))
                .bind(new Taxi("789"))
                .bind(taxi)
                .bind(taxi)
                .bind(handler);

        Order order = new Order("100000");
        handler.handle(order);
    }
}
