package be.burundiroots.BRBLBackEnd.api.controller;

import be.burundiroots.BRBLBackEnd.api.models.user.UserForm;
import be.burundiroots.BRBLBackEnd.api.models.user.UserIndexDTO;
import be.burundiroots.BRBLBackEnd.bll.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserIndexDTO>> getAllUsers(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "email") String sort
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        List<UserIndexDTO> userIndexDTOs = userService.findAllUsers(pageable)
                .getContent()
                .stream().map(UserIndexDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(userIndexDTOs);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserIndexDTO> getUser(@PathVariable String email){
        UserIndexDTO userIndexDTO = UserIndexDTO.fromEntity(userService.findUserByEmail(email));
        return ResponseEntity.ok(userIndexDTO);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(
            @Valid @RequestBody UserForm userForm
            ){
        Long id = userService.save(userForm.ToEntity());
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('USER_WRITE')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserForm userForm
            ){
        userService.update(id, userForm.ToEntity());
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('USER_DELETE')")
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id
    ){
        userService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
