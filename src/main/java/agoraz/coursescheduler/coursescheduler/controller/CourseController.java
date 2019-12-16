package agoraz.coursescheduler.coursescheduler.controller;


import agoraz.coursescheduler.coursescheduler.model.Course;
import agoraz.coursescheduler.coursescheduler.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/courses"})
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    // CRUD methods

    //Retrieve All courses (GET /courses)
    @GetMapping
    public List findAll() {return courseRepository.findAll();}

    //Retrieve a course by ID (GET /courses/{id})
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return courseRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Create a new course (POST /courses)
    @PostMapping//(consumes=MediaType.APPLICATION_JSON_VALUE)
    public Course create(@RequestBody Course course) {

        return courseRepository.save(course);
    }

    //Update a Course (PUT /courses)
    @PutMapping(value="/{id}")
    public ResponseEntity<Course> update(@PathVariable("id") long id,
                                         @RequestBody Course course){
        return courseRepository.findById(id)
                .map(record -> {
                    record.setName(course.getName());
                    Course updated = courseRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //Remove a Course (DELETE /courses/{id})
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return courseRepository.findById(id)
                .map(record -> {
                    courseRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
