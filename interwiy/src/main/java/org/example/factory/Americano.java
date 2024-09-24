package org.example.factory;

public class Americano extends Coffee{
    public Americano(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
