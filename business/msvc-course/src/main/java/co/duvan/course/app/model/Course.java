package co.duvan.course.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    //* Vars
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ElementCollection
    @CollectionTable(name = "course_student")
    @Column(name = "student_id")
    private List<Long> stundetIds;

}
