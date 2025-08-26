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
@Entity(name = "Meeting")
@Table(name = "Meeting")
public class Meeting {

    Long idMeeting;
    String name;
    String type;
    String description;



}
