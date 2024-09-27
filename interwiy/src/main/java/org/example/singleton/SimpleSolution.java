package org.example.singleton;

public class SimpleSolution {

    private static final SimpleSolution INSTANCE = new SimpleSolution();

    private SimpleSolution(){

    }

    public static SimpleSolution getInstance(){
        return INSTANCE;
    }
}
