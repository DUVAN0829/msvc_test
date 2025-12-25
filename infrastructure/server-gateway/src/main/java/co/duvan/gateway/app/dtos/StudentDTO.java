package co.duvan.gateway.app.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {

    //* Vars
    private Long id;
    private String name;
    private int edad;
    private List<CourseDTO> courses;

}
