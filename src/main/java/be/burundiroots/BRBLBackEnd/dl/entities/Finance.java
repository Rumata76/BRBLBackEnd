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
@Table(name = "FINANCE")
@AttributeOverride(name = "id", column = @Column(name = "FINANCE_ID"))
public class Finance extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    String name;

    @Column(nullable = false, length = 50)
    String type;

    @Column(nullable = true)
    String description;

    @ManyToOne
    @JoinColumn(name = "EXTERN_ID")
    private Extern extern;

    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;


    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;



}
