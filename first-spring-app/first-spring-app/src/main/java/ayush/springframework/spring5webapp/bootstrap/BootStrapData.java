package ayush.springframework.spring5webapp.bootstrap;

import ayush.springframework.spring5webapp.repositories.EventRepository;
import ayush.springframework.spring5webapp.repositories.AttendeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// For testing the cases and Storing the data/members in the database
@Component
public class BootStrapData implements CommandLineRunner {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public BootStrapData(EventRepository eventRepository, AttendeeRepository attendeeRepository) {
        this.eventRepository = eventRepository;
        this.attendeeRepository = attendeeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //For creating objects and saving them in their respective repositories.
    }
}
