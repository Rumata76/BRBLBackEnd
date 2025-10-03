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
@Table(name = "EXTERN")
@AttributeOverride(name = "id", column = @Column(name = "EXTERN_ID"))
public class Extern extends BaseEntity{

    @Column(unique = true, nullable = false, length = 50)
    String name;

    @Column(nullable = false, length = 50)
    String type;

    @Column(nullable = true)
    String description;

}
