package org.example.singleton;

public class SynchronizedAccessor {
    private static SynchronizedAccessor INSTANCE;

    private SynchronizedAccessor(){};

    public static synchronized SynchronizedAccessor getInstance(){
        if(INSTANCE == null){
            INSTANCE = new SynchronizedAccessor();
        }
        return INSTANCE;
    }
}
