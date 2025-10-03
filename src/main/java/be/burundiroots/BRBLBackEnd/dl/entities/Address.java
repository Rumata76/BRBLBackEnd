package be.burundiroots.BRBLBackEnd.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
@Table(name = "ADDRESS")
@AttributeOverride(name = "id", column = @Column(name = "ADDRESS_ID"))
public class Address extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 50)
    private String streetNumber;

    @Column(nullable = true, length = 50)
    private String streetbox;

    @Column(nullable = false, length = 50)
    private String postalCode;


}
