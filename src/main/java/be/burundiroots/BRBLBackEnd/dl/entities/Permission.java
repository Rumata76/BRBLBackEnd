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
@EqualsAndHashCode
@Table(name = "PERMISSION")
@AttributeOverride(name = "id", column = @Column(name = "PERMISSION_ID"))
public class Permission {


    @Column(unique = true, nullable = false, length = 50)
    private String ressource;

    @Column(nullable = true, length = 2)
    private String canRead;

    @Column(nullable = true, length = 2)
    private String canWrite;

    @Column(nullable = true, length = 2)
    private String canDelete;

    @ManyToMany(mappedBy = "PERMISSION")
    private List<Role> roles = new ArrayList<>();


}
