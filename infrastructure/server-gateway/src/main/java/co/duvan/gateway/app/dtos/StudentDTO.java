package co.duvan.gateway.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    //* Vars
    private Long id;
    private String name;
    private int edad;
    private List<Long> courseIds;
    private List<CourseDTO> courses;

}
