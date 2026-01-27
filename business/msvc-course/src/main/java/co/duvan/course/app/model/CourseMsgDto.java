package co.duvan.course.app.model;

import java.util.List;

public record CourseMsgDto(String CourseName, List<Long> courseIds) {
}
