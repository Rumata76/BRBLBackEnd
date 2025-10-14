package be.burundiroots.BRBLBackEnd.dl.entities;

import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "ROLES")
@AttributeOverride(name = "id", column = @Column(name = "ROLE_ID"))
public class Role extends BaseEntity<Long> {

    @NonNull
    @Column(unique = true, nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole name;

    @Column(nullable = true)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinTable(
            name = "ROLE_PERMISSION",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID")
    )
    private Set<Permission> permissions = new HashSet<>();


    public Role(UserRole name, String description) {
        this.name = name;
        this.description = description;
    }

    public Set<Permission> getPermissions() {
        return Set.copyOf(this.permissions);
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        this.permissions.remove(permission);
    }

}
