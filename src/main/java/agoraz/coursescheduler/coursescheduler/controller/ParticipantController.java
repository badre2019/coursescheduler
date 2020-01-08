package agoraz.coursescheduler.coursescheduler.controller;

import agoraz.coursescheduler.coursescheduler.model.Participant;
import agoraz.coursescheduler.coursescheduler.repository.ParticipantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/participant"})
public class ParticipantController {

    private ParticipantRepository participantRepository;

    ParticipantController(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    // CRUD methods

    //Retrieve All events (GET /events)
    @GetMapping
    public List findAll() {return participantRepository.findAll();}

    //Create a new member (POST /members)
    @PostMapping
    public Participant create(@RequestBody Participant participant) {

        return participantRepository.save(participant);
    }
}
