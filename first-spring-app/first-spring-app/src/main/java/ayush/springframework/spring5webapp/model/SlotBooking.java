package ayush.springframework.spring5webapp.model;

import org.hibernate.engine.internal.Collections;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class SlotBooking {
    private Attendee attendee;
    private Event event;
    private Date currentDay;
    private Time currentTIme;

    public SlotBooking(Attendee attendee, Event event, Date currentDate, Time currentTIme) {
        this.attendee = attendee;
        this.event = event;
        this.currentDay = currentDate;
        this.currentTIme = currentTIme;
    }

    // Method For registering and storing them into there respective classes
    public void register(){
        // Checking if attendees prior bookings not clashing with the current booking
        for (Event curr : attendee.getRegisteredEvents()){
            if(curr.getEventDay()==currentDay){
                if((curr.getEndTime()>event.getEndTime() && curr.getStartTime()>event.getStartTime()) | (event.getEndTime()>curr.getEndTime() && event.getStartTime()>curr.getStartTime())) {
                    if (event.getAvailability() > 0 && event.getCurrentList().size()< event.getMaxCapacity()) {
                        System.out.println("Successfully Registered for the event");
                        event.setAvailability(event.getAvailability() - 1);
                        attendee.getRegisteredEvents().add(curr);
                        curr.getCurrentList().add(attendee);
                    }
                    else{
                        System.out.println("Sorry no seats available");
                        event.getWaitingList().add(attendee);
                    }
                }
            }
            //If dates are not matching then we can directly check for the availability
            else{
                if(event.getAvailability()>0 && event.getCurrentList().size()< event.getMaxCapacity()){
                    System.out.println("Successfully Registered for the event");
                    event.setAvailability(event.getAvailability()-1);
                    attendee.getRegisteredEvents().add(curr);
                    curr.getCurrentList().add(attendee);
                }
                else{
                    System.out.println("Clash is there");
                }
            }
        }
    }
    public void cancel(){
        attendee.getRegisteredEvents().remove(event);
        event.getCurrentList().remove(attendee);
        event.setAvailability(event.getAvailability()+1);
        List<Attendee> lis= event.getWaitingList();

        // According to the priority and then through the time
//        Collections.sort(lis);


//            For sorting according to the priority we use comparator
//        public static class OrderByAmount implements Comparator<Attendee> {
//
//            @Override
//            public int compare(Attendee a1, Attendee a2) {
//                return a1.priority > o2.priority ? 1 : (o1.priority < o2.priority ? -1 : 0);
//            }
//        }

        if (lis!=null){

            Attendee att = event.getWaitingList().remove(0);
            att.getRegisteredEvents().add(event);
            event.getCurrentList().add(att);
            event.setAvailability(event.getAvailability()-1);

        }

    }
}
