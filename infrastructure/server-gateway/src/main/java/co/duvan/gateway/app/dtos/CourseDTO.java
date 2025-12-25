package co.duvan.gateway.app.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseDTO {

    //* Vars
    private Long id;
    private String courseName;
    private List<Long> stundetIds;
    private List<StudentDTO> Students;

}
