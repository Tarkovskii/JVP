package org.example.singleton;

public class ClassHolderSingleton {

    private ClassHolderSingleton(){}

    private static class CreaterSingletone{
        public static final ClassHolderSingleton HOLDER_SINGLETON = new ClassHolderSingleton();
    }

    public static ClassHolderSingleton getInstance(){
        return CreaterSingletone.HOLDER_SINGLETON;
    }
}
