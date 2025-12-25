package co.duvan.gateway.app.client;

import co.duvan.gateway.app.dtos.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8082", name = "msvc-course")
public interface CourseClient {

    @GetMapping("/api/v1/course/details")
    List<CourseDTO> findAll();

}
