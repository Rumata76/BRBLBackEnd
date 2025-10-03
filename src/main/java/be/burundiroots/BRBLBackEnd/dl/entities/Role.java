package be.burundiroots.BRBLBackEnd.dl.entities;

import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import com.fasterxml.jackson.databind.ser.Serializers;
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
@EqualsAndHashCode(callSuper = false)
@Table(name = "ROLES")
@AttributeOverride(name = "id", column = @Column(name = "ROLE_ID"))
public class Role extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole name;

    @Column(nullable = true)
    private String description;

    @ManyToMany(cascade =  CascadeType.PERSIST)
    @JoinTable(
            name = "ROLE_PERMISSION",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID")
    )
    private List<Permission> permissions = new ArrayList<>();




}
