package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;



@Entity
@Table(name = "tblusers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotBlank
    @Size(max = 80)
    private String email;

    @NotBlank
    @Size(max = 30)
    private String userName;

    @NotBlank
    private  String password;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = RoleEntity.class,cascade=CascadeType.PERSIST)
    @JoinTable(name="user_roles", joinColumns=@JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<RoleEntity> roles;
}
