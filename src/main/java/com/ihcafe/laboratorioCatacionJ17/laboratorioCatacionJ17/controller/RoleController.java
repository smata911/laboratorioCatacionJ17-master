package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.controller;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto.AssignPermissionsDTO;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ERole;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.PermissionEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.RoleEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.PermissionRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;



@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @PostMapping("/assignPermissions")

    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> assignPermissionsToRole(@Valid @RequestBody AssignPermissionsDTO assignPermissionsDTO) {
        RoleEntity role = roleRepository.findByName(ERole.valueOf(assignPermissionsDTO.getRoleName()))
                .orElseThrow(() -> new RuntimeException("Error: Role not found."));

        Set<PermissionEntity> permissions = assignPermissionsDTO.getPermissions().stream()
                .map(permission -> permissionRepository.findByName(permission)
                        .orElseThrow(() -> new RuntimeException("Error: Permission not found.")))
                .collect(Collectors.toSet());

        role.setPermissions(permissions);
        roleRepository.save(role);

        return ResponseEntity.ok("Permissions assigned successfully.");
    }

}
