package be.burundiroots.BRBLBackEnd.dal.utils;

import be.burundiroots.BRBLBackEnd.dal.repositories.CourseRepository;
import be.burundiroots.BRBLBackEnd.dal.repositories.PermissionRepository;
import be.burundiroots.BRBLBackEnd.dal.repositories.RoleRepository;
import be.burundiroots.BRBLBackEnd.dal.repositories.UserRepository;
import be.burundiroots.BRBLBackEnd.dl.entities.*;
import be.burundiroots.BRBLBackEnd.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CourseRepository courseRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public void run(String... args) throws Exception {
        if(courseRepository.count()==0){
            List<Course> courses = List.of(
                    new Course("Kirundi - Abana - débutants", "Cours de Kirundi pour les enfants débutants")
               );
            courseRepository.saveAll(courses);
        }
        if(permissionRepository.count()==0){
            List<Permission> permissions = List.of(
                    new Permission("/course",true,true,true),
                    new Permission("/admin",true,true,true)

            );
            permissionRepository.saveAll(permissions);
        }
        if(roleRepository.count()==0){
            List<Role> roles = List.of(
                new Role(UserRole.ADMIN, "administrateur de l'application",
                        List.of(
                            new Permission("/course",true,true,true),
                            new Permission("/admin",true,true,true)

                        )),
                    new Role(UserRole.PRESIDENT, "Président de l'ASBL Burundi Roots Belgium Life",
                            List.of(
                                        new Permission("/course",true,true,true)

                                )),
                    new Role(UserRole.INVITE, "Invité",
                            List.of(
                                    new Permission("/", true, false, false)
                    )));
            roleRepository.saveAll(roles);
        }

        if(userRepository.count()==0){
            List<User> users = List.of(
                    new User("admin", "rumata76@hotmail.com", "dedansCNJ1!", "Male",  LocalDate.of(1976,10,12), "Etterbeek", null, "+32 478219390", "Burundaise",
                        List.of(new Role(UserRole.ADMIN, "administrateur de l'application",
                                        List.of(
                                                new Permission("/course",true,true,true),
                                                new Permission("/admin",true,true,true)

                                        )),
                                new Role(UserRole.PRESIDENT, "Président de l'ASBL Burundi Roots Belgium Life",
                                        List.of(
                                                new Permission("/course",true,true,true)

                                        )),
                                new Role(UserRole.INVITE, "Invité",
                                        List.of(
                                                new Permission("/", true, false, false)
                                        ))),
                                List.of(new Address("rue du Brou", "Jandrain", "Belgique", "6", null, "1350")),
                                null,
                                new Course("Kirundi - Abana - débutants", "Cours de Kirundi pour les enfants débutants"/*,
                                        new Goal("promotion de la Culture burundaise", "promotion de la Culture burundaise (Kirundi, Kahise, Ubuntu) selon la philosophie de Cheikh Anta Diop et le folklore burundais")*/),
                                null,
                                null
                        ),
                    new User("président", "rumata76@hotmail.com", "dedansCNJ1!","Male", LocalDate.of(1976,10,12), "Etterbeek", null, "+32 478219390", "Burundaise",
                            List.of(
                                    new Role(UserRole.PRESIDENT, "Président de l'ASBL Burundi Roots Belgium Life",
                                            List.of(
                                                    new Permission("/course",true,true,true)

                                            )),
                                    new Role(UserRole.INVITE, "Invité",
                                            List.of(
                                                    new Permission("/", true, false, false)
                                            ))),
                                    List.of(new Address("rue du Brou", "Jandrain", "Belgique", "6", null, "1350")),
                                    null,
                                    new Course("Kirundi - Abana - débutants", "Cours de Kirundi pour les enfants débutants"/*,
                                            new Goal("promotion de la Culture burundaise", "promotion de la Culture burundaise (Kirundi, Kahise, Ubuntu) selon la philosophie de Cheikh Anta Diop et le folklore burundais")*/),
                                    null,
                                    null
                            ));
            userRepository.saveAll(users);


        }
    }

}
