package be.burundiroots.BRBLBackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "Address")
@Table(name = "Address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    private String street;
    private String city;
    private String country;
    private String streetNumber;
    private String streetbox;
    private String postalCode;
    @ManyToMany(mappedBy = "Address")
    private List<User_> users = new ArrayList<>();


}
