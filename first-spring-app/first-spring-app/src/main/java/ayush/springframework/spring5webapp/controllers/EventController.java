package ayush.springframework.spring5webapp.controllers;


import ayush.springframework.spring5webapp.repositories.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository authorRepository, EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @RequestMapping("/events")
    public String getEvents(Model model){
        model.addAttribute("events" , eventRepository.findAll());
        return "events/list";
    }
}
