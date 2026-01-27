package co.duvan.course.app.services;

import co.duvan.course.app.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Optional<Course> findById(Long id);

    List<Course> findAll();

    Course save(Course course);

    void deleteById(Long id);

}
