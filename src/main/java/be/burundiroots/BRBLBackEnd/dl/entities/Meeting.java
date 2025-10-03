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
@Table(name = "MEETING")
@AttributeOverride(name = "id", column = @Column(name = "MEETING_ID"))
public class Meeting extends BaseEntity<Long> {

    @Column(unique = true, nullable = false, length = 50)
    String name;

    @Column(nullable = false, length = 50)
    String type;

    @Column(nullable = true)
    String description;

}
