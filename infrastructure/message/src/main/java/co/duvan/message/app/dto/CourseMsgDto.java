package co.duvan.message.app.dto;

import java.util.List;

public record CourseMsgDto(String CourseName, List<Long> courseIds) {
}