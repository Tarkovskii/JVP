package tutorial.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.telegram.telegrambots.meta.api.objects.Update;

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
