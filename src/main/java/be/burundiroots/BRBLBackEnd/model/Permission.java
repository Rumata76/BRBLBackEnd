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
@Entity(name = "Permission")
@Table(name = "Permission")

public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermission;

    private String ressource;
    private String canRead;
    private String canWrite;
    private String canDelete;

    @ManyToMany(mappedBy = "Permission")
    private List<Roles> roles = new ArrayList<>();


}
