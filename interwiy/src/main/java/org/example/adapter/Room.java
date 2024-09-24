package org.example.adapter;

public class Room {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new SimpleAmericanSocket();
        EuroSocket euroSocket = new SocketAdapter(americanSocket);
        Radio radio = new Radio();
        radio.listenMusic(euroSocket);
    }
}
