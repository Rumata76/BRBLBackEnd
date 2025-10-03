package be.burundiroots.BRBLBackEnd.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "COURSE")
@AttributeOverride(name = "id", column = @Column(name = "COURSE_ID"))
public class Course extends BaseEntity{

    @Column(unique = true, nullable = false, length = 50)
    String name;

    @Column(nullable = true)
    String description;

    @ManyToOne
    @JoinColumn(name = "GOAL_ID")
    private Goal goal;

}

