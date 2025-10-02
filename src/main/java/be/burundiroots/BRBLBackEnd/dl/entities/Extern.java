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
@Entity(name = "Extern")
@Table(name = "Extern")
public class Extern {

    Long idExtern;
    String name;
    String type;
    String description;



}
