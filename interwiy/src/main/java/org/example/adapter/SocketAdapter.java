package org.example.adapter;

public class SocketAdapter implements EuroSocket{
    private AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public void detPower() {
        americanSocket.getPower();

    }
}
