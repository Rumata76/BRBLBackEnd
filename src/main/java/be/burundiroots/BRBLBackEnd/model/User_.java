package be.burundiroots.BRBLBackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity(name = "User_")
@Table(name = "User_")
public class User_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String email;
    private String password;
    private String genre;
    private String birthDate;
    private String placeOfBirth;
    private String fixPhone;
    private String mobilePhone;
    private String nationality;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Roles> roles = @JoinColumn(name = "role_id");

    @ManyToMany
    @JoinTable(
            name = "user_adress",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses = @JoinColumn(name = "address_id");
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "extern_id")
    private Extern extern;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;
}
