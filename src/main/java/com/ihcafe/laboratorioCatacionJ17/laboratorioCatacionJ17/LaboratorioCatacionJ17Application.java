package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ERole;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.Empresa;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.RoleEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.UserEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.EmpresaRepository;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;


@SpringBootApplication

public class  LaboratorioCatacionJ17Application {
private  final EmpresaRepository empresaRepository;

    public LaboratorioCatacionJ17Application(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(LaboratorioCatacionJ17Application.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;
@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init() {
		return args -> {
			// Verificar si ya existen usuarios
			if (userRepository.count() == 0) { // Solo ejecuta si no hay usuarios

				// Crear y guardar una nueva empresa
				Empresa empresa = new Empresa();
				empresa.setId(1); // Asigna el ID que desees
				empresa.setNombre("Empresa de Ejemplo"); // Cambia esto según sea necesario

				// Guarda la empresa en la base de datos
				empresa = empresaRepository.save(empresa); // Guarda y asigna la entidad persistida

				// Crear usuarios asociados a la misma empresa
				UserEntity userEntity = UserEntity.builder()
						.email("sergiomata911@gmail.com")
						.userName("smata")
						.empresa(empresa) // Asociar la empresa
						.password(passwordEncoder.encode("1234"))
						.roles(Set.of(RoleEntity.builder()
								.name(ERole.valueOf(ERole.ADMIN.name()))
								.build()))
						.build();

				UserEntity userEntity2 = UserEntity.builder()
						.email("josue911@gmail.com")
						.userName("josue")
						.empresa(empresa) // Asociar la misma empresa
						.password(passwordEncoder.encode("1234"))
						.roles(Set.of(RoleEntity.builder()
								.name(ERole.valueOf(ERole.INVITED.name()))
								.build()))
						.build();

				UserEntity userEntity3 = UserEntity.builder()
						.email("duber@gmail.com")
						.userName("duber")
						.empresa(empresa) // Asociar la misma empresa
						.password(passwordEncoder.encode("1234"))
						.roles(Set.of(RoleEntity.builder()
								.name(ERole.valueOf(ERole.USER.name()))
								.build()))
						.build();

				// Guardar los usuarios
				userRepository.save(userEntity);
				userRepository.save(userEntity2);
				userRepository.save(userEntity3);
			} else {
				System.out.println("Los usuarios ya existen en la base de datos.");
			}
		};
	}

}

