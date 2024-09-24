package org.example.composite;

public class TreningComposite {
    public static void main(String[] args) {
        Composite composite = new Composite();

        Steak steak = new Steak();
        Thre thre = new Thre();

        composite.add(steak);
        composite.add(thre);

        composite.show();
    }
}
