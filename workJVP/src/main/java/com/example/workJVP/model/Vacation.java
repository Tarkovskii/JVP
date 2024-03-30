package com.example.workJVP;

import javax.sound.midi.Soundbank;
import java.sql.Date;

public class Vacation {
    private Long id;
    private Long userId;
    private Date startVacation;
    private Date endVacation;

    public Vacation() {
    }

    public Vacation(Long userId, Date startVacation, Date endVacation) {
        this.userId = userId;
        this.startVacation = startVacation;
        this.endVacation = endVacation;
    }

    public Vacation(Long id, Long userId, Date startVacation, Date endVacation) {
        this.id = id;
        this.userId = userId;
        this.startVacation = startVacation;
        this.endVacation = endVacation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getStartVacation() {
        return startVacation;
    }

    public void setStartVacation(Date startVacation) {
        this.startVacation = startVacation;
    }

    public Date getEndVacation() {
        return endVacation;
    }

    public void setEndVacation(Date endVacation) {
        this.endVacation = endVacation;
    }

    public boolean checkValidVacation(Vacation vacation) {
        if (vacation.userId != null &
                vacation.startVacation != null &
                vacation.endVacation != null &
                vacation.startVacation.before(vacation.endVacation)) {
            System.out.println("Dates validation invalidation!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
            return true;
        }
        System.out.println("Dates invalidation!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
        return false;

    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", userId=" + userId +
                ", startVacation=" + startVacation +
                ", endVacation=" + endVacation +
                '}';
    }
}
