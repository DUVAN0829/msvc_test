package co.duvan.course.app.repository;

import co.duvan.course.app.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
