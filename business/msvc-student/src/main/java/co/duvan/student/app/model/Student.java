package co.duvan.student.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    //* Vars
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int edad;

    @ElementCollection
    @CollectionTable(name = "student_course")
    @Column(name = "course_id")
    private List<Long> courseIds;

}
