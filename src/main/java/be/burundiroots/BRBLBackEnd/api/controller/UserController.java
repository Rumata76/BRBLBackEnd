package be.burundiroots.BRBLBackEnd.api.controller;

import be.burundiroots.BRBLBackEnd.api.models.user.UserIndexDTO;
import be.burundiroots.BRBLBackEnd.bll.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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
            @RequestParam(required = false, defaultValue = "name") String sort
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
            @Valid @RequestBody UserForm userForm){}
}
