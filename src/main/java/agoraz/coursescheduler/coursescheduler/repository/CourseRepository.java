package agoraz.coursescheduler.coursescheduler.repository;

import agoraz.coursescheduler.coursescheduler.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
