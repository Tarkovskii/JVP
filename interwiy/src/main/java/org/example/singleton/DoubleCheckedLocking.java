package org.example.singleton;

import java.util.PrimitiveIterator;

public class DoubleCheckedLocking {
    private static DoubleCheckedLocking INSTANCE;

    private DoubleCheckedLocking(){

    }

    public static DoubleCheckedLocking getInstance(){
        if(INSTANCE == null){
            synchronized (DoubleCheckedLocking.class){
                if (INSTANCE==null){
                    INSTANCE = new DoubleCheckedLocking();
                }
            }
        }
        return INSTANCE;
    }
}
