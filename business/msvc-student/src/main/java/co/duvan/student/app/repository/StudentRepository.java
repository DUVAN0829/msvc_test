package co.duvan.student.app.repository;

import co.duvan.student.app.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
