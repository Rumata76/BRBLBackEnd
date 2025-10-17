package be.burundiroots.BRBLBackEnd.api.models.course;

import be.burundiroots.BRBLBackEnd.dl.entities.Course;

public record CourseIndexDto(
        Long id,
        String name,
        String description
) {
    public static CourseIndexDto fromEntity(Course course){
        return new CourseIndexDto(course.getId(), course.getName(), course.getDescription());
    }
}
