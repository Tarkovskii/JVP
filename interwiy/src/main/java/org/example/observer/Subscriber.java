package org.example.observer;

import java.util.List;

public class Subscriber implements Observer{
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> vacancies) {
        System.out.println("Dear " +name+ " we have some changes in vacancies:\n"+vacancies+"\n============================================\n");
    }
}
