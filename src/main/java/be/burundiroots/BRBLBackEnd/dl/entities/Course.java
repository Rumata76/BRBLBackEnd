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
public class Course extends BaseEntity<Long>{

    @Column(unique = true, nullable = false, length = 50)
    String name;

    @Column( nullable = false, length = 50)
    String category;

    @Column( nullable = false, length = 50)
    String level;

    @Column(nullable = true)
    String description;

}

