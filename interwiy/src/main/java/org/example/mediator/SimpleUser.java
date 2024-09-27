package org.example.mediator;

public class SimpleUser implements User{

    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message,this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Simple user get message: " + message);
    }
}
