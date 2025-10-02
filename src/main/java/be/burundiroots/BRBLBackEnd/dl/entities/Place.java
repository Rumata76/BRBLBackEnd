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
@Table(name = "PLACE")
@AttributeOverride(name = "id", column = @Column(name = "PLACE_ID"))
public class Place {

    @Column(unique = true, nullable = false, length =50)
    String name;

    @Column(nullable = false, length = 50)
    String type;

    @Column(nullable = true)
    String description;

    @ManyToOne
    @JoinColumn(name = "GOAL_ID")
    private Goal goal;

    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;

}
