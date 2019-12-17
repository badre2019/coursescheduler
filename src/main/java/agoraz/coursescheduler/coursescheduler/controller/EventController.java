package agoraz.coursescheduler.coursescheduler.controller;

import agoraz.coursescheduler.coursescheduler.repository.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/events"})
public class EventController {

    EventRepository eventRepository;

    EventController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    // CRUD methods

    //Retrieve All events (GET /events)
    @GetMapping
    public List findAll() {return eventRepository.findAll();}
}
