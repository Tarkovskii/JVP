package org.example.adapter;

public class SimpleAmericanSocket implements AmericanSocket{
    @Override
    public void getPower() {
        System.out.println("get 110 v");
    }
}
