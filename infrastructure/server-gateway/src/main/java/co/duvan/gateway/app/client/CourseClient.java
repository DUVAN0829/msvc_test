package co.duvan.gateway.app.client;

import co.duvan.gateway.app.dtos.CourseDTO;
import co.duvan.gateway.app.dtos.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "msvc-course", url = "${msvc.course.url}")
public interface CourseClient {

    @GetMapping("/api/v1/course/all-by-ids")
    List<CourseDTO> findAllByIds(@RequestParam List<Long> ids);

    @GetMapping("/api/v1/course/{id}")
    Optional<CourseDTO> findById(@PathVariable Long id);


}
