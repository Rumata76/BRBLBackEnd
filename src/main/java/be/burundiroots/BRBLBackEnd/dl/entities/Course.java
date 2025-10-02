package be.burundiroots.BRBLBackEnd.dl.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Course")
@Table(name = "Course")
public class Course {

    Long idCourse;
    String name;
    String description;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

}

