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
@ToString(callSuper= true, of = {"email","firstname","lastname","roles"})
@EqualsAndHashCode(callSuper = true, of = {"email"})
@Table(name = "USERS")
@AttributeOverride(name= "id", column=@Column(name = "USER_ID"))
public class User extends BaseEntity<Long> implements UserDetails {

    @Column(unique = true, nullable = false, length = 50)
    private String username;


    @Column(unique = true, nullable = false, length = 50)
    private String email;


    @Column(nullable = false)
    private String password;


    @Column(nullable = false, length = 100)
    private String firstname;


    @Column(nullable = false, length = 100)
    private String lastname;


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


    public User(String username, String email, String password, String firstname, String lastname, String genre, LocalDate birthDate, String placeOfBirth, String fixPhone, String  mobilePhone, String nationality) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.genre = genre;
        this.birthDate = birthDate;
        this.placeOfBirth = placeOfBirth;
        this.fixPhone = fixPhone;
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

        Set<GrantedAuthority> auth = new HashSet<>();
        for(Role rol : roles){
          for(Permission perm : rol.getPermissions()){
              if(perm.isCanRead()){

                auth.add(new SimpleGrantedAuthority(perm.getRessource() + "_READ"));
              }
              if(perm.isCanWrite()){

                  auth.add(new SimpleGrantedAuthority(perm.getRessource() + "_WRITE"));
              }
              if(perm.isCanDelete()){

                  auth.add(new SimpleGrantedAuthority(perm.getRessource() + "_DELETE"));
              }
          }
        }

        return auth;
    }
}
