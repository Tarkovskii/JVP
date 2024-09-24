package org.example.strategy;

public class PoligonStrategy {
    public static void main(String[] args) {
        Auto sedan = new Sedan();
        Auto fq = new FqCar();
        Auto track = new Track();

        sedan.fill();
        fq.fill();
        track.fill();
    }
}
