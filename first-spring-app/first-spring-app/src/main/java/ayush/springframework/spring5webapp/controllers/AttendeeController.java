package ayush.springframework.spring5webapp.controllers;

import ayush.springframework.spring5webapp.repositories.AttendeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttendeeController {

    private final AttendeeRepository attendeeRepository;
    public AttendeeController(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @RequestMapping("/attendee")
    public String getAttendees(Model model){
        model.addAttribute("attendee",attendeeRepository.findAll());
        return "attendee/list";
    }
}
