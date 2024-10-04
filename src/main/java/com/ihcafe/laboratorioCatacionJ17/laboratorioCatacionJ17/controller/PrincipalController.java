package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.CreateUserDTO;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ERole;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.RoleEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.UserEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){
        return "hollo word not secured";
    }



    @GetMapping("/helloSecure")
    public String helloSecured(){
        return "hollo word segured";
    }

    @PostMapping("/createUser")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?>createUser(@Valid @RequestBody  CreateUserDTO createUserDTO){
        //esta logica tiene que ir en el impl
        Set<RoleEntity> roles=createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity= UserEntity.builder()
                .userName(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();
        userRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);

    }
@DeleteMapping("/deleteUser")
@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")

public String  deleteUser(@RequestParam String id){

        userRepository.deleteById(Long.parseLong(id));

        return "se ha borrao el user".concat(id);

}

}
