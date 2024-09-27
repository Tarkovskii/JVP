package org.example.factory;

public class CaffeLatte extends Coffee {
    public CaffeLatte(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return getName();
    }
}
