package be.burundiroots.BRBLBackEnd.model;

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
@Entity(name = "Logistic")
@Table(name = "Logistic")
public class Logistic {

    Long idLogistic;
    String name;
    String available;
    String type;
    String description;

    @ManyToOne
    @JoinColumn(name = "extern_id")
    private Extern extern;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;



}
