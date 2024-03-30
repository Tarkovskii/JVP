package com.example.workJVP;

import org.springframework.stereotype.Component;


import java.net.Socket;
import java.sql.Date;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private Date dateRegistration;
    private List<Vacation> vacations;

    public User() {
    }

    public User(String name){
        this.name = name;
    }

    public User(Long id, String name, Date dateRegistration, List<Vacation> vacations) {
        this.id = id;
        this.name = name;
        this.dateRegistration = dateRegistration;
        this.vacations = vacations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public List<Vacation> vacations(){
        return vacations;
    }

    public boolean checkOnValidationUser(User user){
        user.name = user.name.replaceAll(" ","");
        if(user.name != null & !user.name.equals(" ") & !user.name.equals("")){
            return true;
        }else {
            return false;
            //throw new RuntimeException("Not validation User.name");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", vacations=" + vacations +
                '}';
    }
}
