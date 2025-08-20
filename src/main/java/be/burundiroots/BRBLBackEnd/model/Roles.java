package be.burundiroots.BRBLBackEnd.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "roles_permission",
            joinColumns = @JoinColumn(name = "idRole"),
            inverseJoinColumns = @JoinColumn(name = "idPermission")
    )

    private List<Permission> permissions = @JoinColumn(name = "idPermission");

    @ManyToMany(mappedBy = "Roles")
    private List<User_> users = new ArrayList<>();

    public Long getIdRole(){
        return idRole;
    }
    public void setIdRole(Long idRole){
        this.idRole = idRole;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public List<User_> getUsers() {
        return users;
    }

    public void setUsers(List<User_> users) {
        this.users = users;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }


}
