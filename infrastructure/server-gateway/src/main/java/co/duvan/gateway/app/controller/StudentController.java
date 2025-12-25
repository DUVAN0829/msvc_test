package co.duvan.gateway.app.controller;

import co.duvan.gateway.app.client.CourseClient;
import co.duvan.gateway.app.client.StudentClient;
import co.duvan.gateway.app.dtos.StudentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    //* Vars
    private final StudentClient clientStudent;
    private final CourseClient courseClient;

    public StudentController(StudentClient client, CourseClient courseClient) {
        this.clientStudent = client;
        this.courseClient = courseClient;
    }

    //* Handler methods

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findByid(@PathVariable Long id) {

        Optional<StudentDTO> studentOptional = clientStudent.findById(id);

        if(studentOptional.isPresent()) {

            StudentDTO student = new StudentDTO();

            student.setId(studentOptional.get().getId());
            student.setName(studentOptional.get().getName());
            student.setEdad(studentOptional.get().getEdad());
            student.setCourses(courseClient.findAllByIds(studentOptional.get().getCourseIds()));

            return ResponseEntity.ok(student);

        }

        return ResponseEntity.notFound().build();

    }

}





































