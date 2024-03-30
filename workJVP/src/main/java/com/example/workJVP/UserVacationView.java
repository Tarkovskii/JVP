package com.example.workJVP;

import java.sql.Date;

public class UserVacationView {
    private String nameUser;
    private Long vacationId;
    private Date vacationStart;
    private Date vacationEnd;

    public UserVacationView() {
    }

    public UserVacationView(String nameUser, Long vacationId, Date vacationStart, Date vacationEnd) {
        this.nameUser = nameUser;
        this.vacationId = vacationId;
        this.vacationStart = vacationStart;
        this.vacationEnd = vacationEnd;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Long getVacationId() {
        return vacationId;
    }

    public void setVacationId(Long vacationId) {
        this.vacationId = vacationId;
    }

    public Date getVacationStart() {
        return vacationStart;
    }

    public void setVacationStart(Date vacationStart) {
        this.vacationStart = vacationStart;
    }

    public Date getVacationEnd() {
        return vacationEnd;
    }

    public void setVacationEnd(Date vacationEnd) {
        this.vacationEnd = vacationEnd;
    }

    @Override
    public String toString() {
        return "UserVacationView{" +
                "nameUser='" + nameUser + '\'' +
                ", vacationId=" + vacationId +
                ", vacationStart=" + vacationStart +
                ", vacationEnd=" + vacationEnd +
                '}';
    }
}
