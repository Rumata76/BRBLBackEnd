package be.burundiroots.BRBLBackEnd.api.controller;

import be.burundiroots.BRBLBackEnd.bll.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserIndexDTO>> getAllUsers(){}
}
