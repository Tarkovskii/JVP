package org.example.singleton;

public class SingletoneRun {
    public static void main(String[] args) {
        System.out.println(SimpleSolution.getInstance());
        System.out.println(LazzyInitialization.getInstance());
        System.out.println(SynchronizedAccessor.getInstance());
        System.out.println(DoubleCheckedLocking.getInstance());
        System.out.println(ClassHolderSingleton.getInstance());




    }
}
