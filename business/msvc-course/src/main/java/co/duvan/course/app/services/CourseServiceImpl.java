package co.duvan.course.app.services;

import co.duvan.course.app.model.Course;
import co.duvan.course.app.model.CourseMsgDto;
import co.duvan.course.app.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    //* Vars
    private final CourseRepository repository;
    private static final Logger log = LoggerFactory.getLogger(CourseService.class);
    private final StreamBridge streamBridge;

    //* Methods
    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) repository.findAll();
    }

    @Override
    public Course save(Course course) {

        Course courseDb = repository.save(course);
        sendCommunication(courseDb);

        return courseDb;
    }

    private void sendCommunication(Course course) {

        CourseMsgDto courseDto = new CourseMsgDto(course.getCourseName(), course.getStundetIds());

        log.info("Sending communication request for the details {}", courseDto);

        Boolean isSendMessage = streamBridge.send("sendCommunication-out-0", courseDto);

        log.info("Is the Communication request successfully processed {}", isSendMessage);

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
