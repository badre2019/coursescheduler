package agoraz.coursescheduler.coursescheduler.repository;

import agoraz.coursescheduler.coursescheduler.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
