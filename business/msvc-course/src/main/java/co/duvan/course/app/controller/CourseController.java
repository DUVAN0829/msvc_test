package co.duvan.course.app.controller;

import co.duvan.course.app.model.Course;
import co.duvan.course.app.repository.CourseRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    //* Vars
    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    //* Handler methods

    @GetMapping("/details")
    public ResponseEntity<List<Course>> findAll() {

        return ResponseEntity.ok((List<Course>) repository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {

        Optional<Course> courseOptional = repository.findById(id);

        if (courseOptional.isPresent()) {
            return ResponseEntity.ok(courseOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        Optional<Course> courseOptional = repository.findById(id);

        if(courseOptional.isPresent()) {

            repository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }

}

