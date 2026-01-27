package co.duvan.student.app.controller;

import co.duvan.student.app.model.Student;
import co.duvan.student.app.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
@Slf4j
public class StudentController {

    //* Vars
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    //* Handler Methods

    @GetMapping("/details")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok((List<Student>) repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {

        Optional<Student> studentOptional = repository.findById(id);

        if (studentOptional.isPresent()) {
            //log.info("[" + correlationId + "]" + "Fetching student id=" + id);
            return ResponseEntity.ok(studentOptional.orElseThrow());
        }

        //log.info("[" + correlationId + "] Student not found");
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(student));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        Optional<Student> studentOptional = repository.findById(id);

        if (studentOptional.isPresent()) {

            repository.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/all-by-ids")
    public ResponseEntity<List<Student>> findAllByIds(@RequestParam List<Long> ids) {

        return ResponseEntity.ok((List<Student>) repository.findAllById(ids));

    }

}





















