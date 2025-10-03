package be.burundiroots.BRBLBackEnd.dal.utils;

import be.burundiroots.BRBLBackEnd.dal.repositories.RoleRepository;
import be.burundiroots.BRBLBackEnd.dal.repositories.UserRepository;
import be.burundiroots.BRBLBackEnd.dl.entities.Role;
import be.burundiroots.BRBLBackEnd.dl.entities.Permission;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0){
            List<Role> roles = List.of(
                new Role(UserRole.ADMIN, "administrateur de l'application",
                        List<Permission> p = List.of(
                        new Permission("/course",true,true,true),
                        new Permission("/admin",true,true,true)

                        )),
                    new Role(UserRole.PRESIDENT, "Président de l'ASBL Burundi Roots Belgium Life",
                            new List<Permission> p = List.of(
                                        new Permission("/course",true,true,true)

                                )));

        }
    }

}
