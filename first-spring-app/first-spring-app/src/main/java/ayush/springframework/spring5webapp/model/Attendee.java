package ayush.springframework.spring5webapp.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String typeOfGuest;
    private int priority;

    public List<Event> getRegisteredEvents() {
        return registeredEvents;
    }

    public void setRegisteredEvents(List<Event> registeredEvents) {
        this.registeredEvents = registeredEvents;
    }

    private List<Event> registeredEvents;

    public Attendee(String firstName, String lastName, String typeOfGuest, int priority, List<Event> registeredEvents) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfGuest = typeOfGuest;
        this.priority = priority;
        this.registeredEvents = registeredEvents;
    }

    public Attendee() {
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority() {
        if (typeOfGuest=="special-guest"){
            this.priority =1;
        }
        else if(typeOfGuest=="business-person"){
            this.priority = 2;
        }
        else if(typeOfGuest=="professor"){
            this.priority = 3;
        }
        else if(typeOfGuest=="student"){
            this.priority = 4;
        }
    }

    // Just returning the ID and the priority , so that we can store in the waiting/current list
    @Override
    public String toString() {
        return "Attendee{" +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attendee attendee = (Attendee) o;

        return Objects.equals(id, attendee.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
