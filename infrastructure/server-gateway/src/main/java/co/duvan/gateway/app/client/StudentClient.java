package co.duvan.gateway.app.client;

import co.duvan.gateway.app.dtos.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "http://localhost:8081", name = "msvc-student")
public interface StudentClient {

    @GetMapping("/api/v1/student/all-by-ids")
    List<StudentDTO> findAllByIds(@RequestParam List<Long> ids);

    @GetMapping("/api/v1/student/{id}")
    Optional<StudentDTO> findById(@PathVariable Long id);

}
