package be.burundiroots.BRBLBackEnd.dl.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "USERS")
@AttributeOverride(name= "id", column=@Column(name = "USER_ID"))
public class User extends BaseEntity<Long> implements UserDetails {

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = true)
    private String placeOfBirth;

    @Column(nullable = true)
    private String fixPhone;

    @Column(nullable = false)
    private String mobilePhone;

    @Column(nullable = false)
    private String nationality;

    @ManyToMany(cascade =  CascadeType.PERSIST)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(cascade =  CascadeType.PERSIST)
    @JoinTable(
            name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private List<Address> addresses = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "EXTERN_ID")
    private Extern extern;

    @ManyToOne
    @JoinColumn(name = "MEETING_ID")
    private Meeting meeting;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List auth = new ArrayList();
        for(Role rol : roles){
          auth.add(new SimpleGrantedAuthority(rol.getName().toString()));
        }

        return auth;
    }
}
