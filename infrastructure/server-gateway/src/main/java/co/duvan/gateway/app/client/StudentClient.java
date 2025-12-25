package co.duvan.gateway.app.client;

import co.duvan.gateway.app.dtos.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081", name = "msvc-student")
public interface StudentClient {

    @GetMapping("/api/v1/stundet/details")
    List<StudentDTO> findAll();

}
