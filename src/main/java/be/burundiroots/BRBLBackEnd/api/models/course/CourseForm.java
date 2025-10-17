package be.burundiroots.BRBLBackEnd.api.models.course;

import be.burundiroots.BRBLBackEnd.dl.entities.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseForm(
    @NotBlank
    @Size(max = 50)
    String name,

    String description
) {
    public Course ToEntity() {
        return new Course(
            name,
            description
            );
    }
}
