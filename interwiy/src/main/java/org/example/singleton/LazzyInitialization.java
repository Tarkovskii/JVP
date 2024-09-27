package org.example.singleton;

public class LazzyInitialization {
    private static LazzyInitialization INSTANCE;

    private LazzyInitialization(){};


    public static LazzyInitialization getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazzyInitialization();
        }
        return INSTANCE;
    }

}
