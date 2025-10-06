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
@Table(name = "GOAL")
@AttributeOverride(name = "id", column = @Column(name = "GOAL_ID"))
public class Goal extends BaseEntity<Long>{

    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String description;
}
