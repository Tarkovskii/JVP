package tutorial.model;

import tutorial.Bot;

import java.util.ArrayList;

public class UserVacationView {
    private User user;
    private ArrayList<Vacation> vacations;

    public UserVacationView() {
    }

    public UserVacationView(User user, ArrayList<Vacation> vacations) {
        this.user = user;
        this.vacations = vacations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(ArrayList<Vacation> vacations) {
        this.vacations = vacations;
    }

    @Override
    public String toString() {
        return "UserVacationView{" +
                "user=" + user +
                ", vacations=" + vacations +
                '}';
    }
}
