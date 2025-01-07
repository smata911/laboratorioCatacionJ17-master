package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignPermissionsDTO {

    private String roleName;  // Nombre del rol, por ejemplo "INVITED"
    private Set<String> permissions;  // Lista de permisos a asignar como "LECTURA_PRODUCER"

}
