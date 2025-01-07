package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.CreateUserDTO;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ERole;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.RoleEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.UserEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.RoleRepository;
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



    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("/hello")
    public String hello(){
        return "hollo word not secured";
    }



    @GetMapping("/helloSecure")
    public String helloSecured(){
        return "hollo word segured";
    }
//aqui
    @PostMapping("/createUser")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> roleRepository.findByName(ERole.valueOf(role))
                        .orElseThrow(() -> new RuntimeException("Error: Role not found.")))
                .collect(Collectors.toSet());

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(createUserDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        userEntity.setEmail(createUserDTO.getEmail());
        userEntity.setRoles(roles);
        userEntity.setEmpresa(createUserDTO.getCodempresa());

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
