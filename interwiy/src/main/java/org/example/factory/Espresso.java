package org.example.factory;

public class Espresso extends Coffee{
    public Espresso(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
