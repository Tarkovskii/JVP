package org.example.mediator;

public class DemoMediator {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();

        User admin = new Admin(textChat);
        User u1 = new SimpleUser(textChat);
        User u2 = new SimpleUser(textChat);

        textChat.setAdmin(admin);
        textChat.addUser(u1);
        textChat.addUser(u2);

        u1.sendMessage("Hello, pisski");
        admin.sendMessage("Hello, pridurki");
    }
}
