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
@EqualsAndHashCode(callSuper = false)
@Table(name = "PERMISSION")
@AttributeOverride(name = "id", column = @Column(name = "PERMISSION_ID"))
public class Permission extends BaseEntity {


    @Column(unique = true, nullable = false, length = 50)
    private String ressource;

    @Column(nullable = true)
    private boolean canRead;

    @Column(nullable = true)
    private boolean canWrite;

    @Column(nullable = true)
    private boolean canDelete;



}
