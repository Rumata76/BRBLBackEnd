package be.burundiroots.BRBLBackEnd.dal.utils;

import be.burundiroots.BRBLBackEnd.dal.repositories.*;
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
    private final AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {



        Address address_admin = new Address("rue du Brou", "Jandrain", "Belgique", "6", "1350");

        if(addressRepository.count() == 0){
            address_admin = addressRepository.save(address_admin);
        }

        Course cours = new Course("Kirundi - Abana - débutants", "Cours de Kirundi pour les enfants débutants");

        if(courseRepository.count() == 0){
            cours = courseRepository.save(cours);
        }

        Permission permission_course = new Permission("/course",true,true,true);
        Permission permission_invite = new Permission("/",true,false,false);

        if(permissionRepository.count()==0){
            permission_course = permissionRepository.save(permission_course);
            permission_invite = permissionRepository.save(permission_invite);
        }

        Role role_admin = new Role(UserRole.ADMIN);

        Role role_president =
                new Role(UserRole.PRESIDENT);
        Role role_invite = new Role(UserRole.INVITE);

        if(roleRepository.count()==0){

            role_admin.getPermissions().add(permission_course);
            role_admin.getPermissions().add(permission_invite);

            role_admin = roleRepository.save(role_admin);

            role_president.getPermissions().add(permission_course);
            role_president.getPermissions().add(permission_invite);

            role_president = roleRepository.save(role_president);

            role_invite.getPermissions().add(permission_invite);

            role_invite = roleRepository.save(role_invite);


        }

        if(userRepository.count()==0){

            User user_admin = new User("admin", "rumata76@hotmail.com", "dedansCNJ1!", "Male",  LocalDate.of(1976,10,12), "Etterbeek", "+32 478219390", "Burundaise");

            user_admin.getRoles().add(role_admin);
            user_admin.getRoles().add(role_president);
            user_admin.getRoles().add(role_invite);

            user_admin.getAddresses().add(address_admin);

            user_admin.getCourses().add(cours);

            user_admin = userRepository.save(user_admin);

            User user_president = new User("président", "burundirootsbelgiumlife@outlook.fr", "dedansBRBL26","Male", LocalDate.of(1976,10,12), "Etterbeek",  "+32 478219390", "Burundaise");

            user_president.getRoles().add(role_president);
            user_president.getRoles().add(role_invite);

            user_president.getAddresses().add(address_admin);

            user_president.getCourses().add(cours);

            user_president = userRepository.save(user_president);



        }
    }

}
