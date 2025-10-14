package be.burundiroots.BRBLBackEnd.dl.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch =  FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinTable(
            name = "USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany(fetch =  FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinTable(
            name = "USER_COURSE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private List<Course> courses = new ArrayList<>();

    /*@ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "EXTERN_ID")
    private Extern extern;

    @ManyToOne
    @JoinColumn(name = "MEETING_ID")
    private Meeting meeting;
*/
    public User(String username, String email, String password, String genre, LocalDate birthDate, String placeOfBirth, String  mobilePhone, String nationality) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.genre = genre;
        this.birthDate = birthDate;
        this.placeOfBirth = placeOfBirth;
        this.mobilePhone = mobilePhone;
        this.nationality = nationality;

    }

    public Set<Role> getRoles() {
        return Set.copyOf(this.roles);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List auth = new ArrayList();
        for(Role rol : roles){
          auth.add(new SimpleGrantedAuthority(rol.getName().toString()));
        }

        return auth;
    }
}
