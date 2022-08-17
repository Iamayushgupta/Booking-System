package ayush.springframework.spring5webapp.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    // We will maintain a 24hr clock
    private Time startTime;
    private Time endTime;
    private Time registrationEndTime;

    private Date eventDay;
    private Date registrationClosingDay;

    private int maxCapacity;
    private int availability;
    private List<Attendee> waitingList;
    private List<Attendee> currentList;

    public Event() {
    }

    public Event(String type, Time startTime, Time endTime, Time registrationEndTime, Date eventDay, Date registrationClosingDay, int maxCapacity, int availability, List<Attendee> waitingList, List<Attendee> currentList) {
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.registrationEndTime = registrationEndTime;
        this.eventDay = eventDay;
        this.registrationClosingDay = registrationClosingDay;
        this.maxCapacity = maxCapacity;
        this.availability = availability;
        this.waitingList = waitingList;
        this.currentList = currentList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(Time registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    public Date getEventDay() {
        return eventDay;
    }

    public void setEventDay(Date eventDay) {
        this.eventDay = eventDay;
    }

    public Date getRegistrationClosingDay() {
        return registrationClosingDay;
    }

    public void setRegistrationClosingDay(Date registrationClosingDay) {
        this.registrationClosingDay = registrationClosingDay;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public List<Attendee> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(List<Attendee> waitingList) {
        this.waitingList = waitingList;
    }

    public List<Attendee> getCurrentList() {
        return currentList;
    }

    public void setCurrentList(List<Attendee> currentList) {
        this.currentList = currentList;
    }
}
