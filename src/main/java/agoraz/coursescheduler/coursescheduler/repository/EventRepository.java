package agoraz.coursescheduler.coursescheduler.repository;

import agoraz.coursescheduler.coursescheduler.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
