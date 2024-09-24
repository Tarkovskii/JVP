package org.example.strategy;

public class Track extends Auto{

    public Track() {
        this.fillable = new HybridFillStrategy();
    }
}
