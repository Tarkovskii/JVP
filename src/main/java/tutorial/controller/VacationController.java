package tutorial.controller;

import tutorial.model.User;
import tutorial.model.Vacation;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class VacationController {
    private StringBuilder startVac;
    private StringBuilder endVac;

    public VacationController() {
        this.startVac = new StringBuilder();
        this.endVac = new StringBuilder();
    }

    public StringBuilder getStartVac() {
        return startVac;
    }

    public void setStartVac(StringBuilder startVac) {
        this.startVac = startVac;
    }

    public StringBuilder getEndVac() {
        return endVac;
    }

    public void setEndVac(StringBuilder endVac) {
        this.endVac = endVac;
    }

    public void addElemStartVac(String elem){
        this.startVac.append(elem);
    }

    public void addElemEndVac(String elem){
        this.endVac.append(elem);
    }

    public boolean isValidStartVac() {
        if (this.startVac.length() == 10) {
            return true;
        }
        return false;
    }
    public boolean isValidEndVac() {
        if (this.endVac.length() == 10) {
            return true;
        }
        return false;
    }

    public  Vacation mapperVacationControllerToVacation(User user){
        Vacation vacation = new Vacation();
        vacation.setUserId(user.getId());
        vacation.setStartVacation(mapperElementVacationControllerToDate(this.startVac));
        vacation.setEndVacation(mapperElementVacationControllerToDate(this.endVac));
        return vacation;

    }

    private static Date mapperElementVacationControllerToDate(StringBuilder elemVacControl){
        return Date.valueOf(elemVacControl.toString());
    }

    @Override
    public String toString() {
        return "VacationController{" +
                "startVac=" + startVac +
                ", endVac=" + endVac +
                '}';
    }
}
