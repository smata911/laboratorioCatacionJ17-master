package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.ERole;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.RoleEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.UserEntity;
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

	public static void main(String[] args) {
		SpringApplication.run(LaboratorioCatacionJ17Application.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;
@Autowired
	UserRepository userRepository;

@Bean
CommandLineRunner init(){

		return args -> {
			UserEntity userEntity=UserEntity.builder()
					.email("sergiomata911@gmail.com")
					.userName("smata")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();



			UserEntity userEntity2=UserEntity.builder()
					.email("josue911@gmail.com")
					.userName("josue")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.INVITED.name()))
							.build()))
					.build();
			UserEntity userEntity3=UserEntity.builder()
					.email("duber@gmail.com")
					.userName("duber")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();
			//userRepository.save(userEntity);
			//userRepository.save(userEntity2);
			//userRepository.save(userEntity);
		};

}
}
