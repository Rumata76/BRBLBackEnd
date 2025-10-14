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
public class Permission extends BaseEntity<Long> {

    @Column(nullable = false, length = 50)
    private String ressource;

    @Column(nullable = false)
    private boolean canRead;

    @Column(nullable = false)
    private boolean canWrite;

    @Column(nullable = false)
    private boolean canDelete;



}
