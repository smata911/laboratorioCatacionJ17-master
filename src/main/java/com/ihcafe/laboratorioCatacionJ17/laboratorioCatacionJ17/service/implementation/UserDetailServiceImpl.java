package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.model.UserEntity;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("EL USUARIO"+username+"no existe"));

       // Collection<? extends GrantedAuthority> authorities=userEntity.getRoles().stream().map(role-> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
        //        .collect(Collectors.toSet());
       // Collection<? extends GrantedAuthority> authorities = userEntity.getRoles().stream()
        //        .flatMap(role -> role.getPermissions().stream()
         //               .map(permission -> new SimpleGrantedAuthority(permission.getName()))) // Asumiendo que tienes una lista de permisos en cada rol
         //       .collect(Collectors.toSet());
        // Autoridades de permisos
        Collection<GrantedAuthority> authorities = userEntity.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getName())))
                .collect(Collectors.toSet());

        // Autoridades de roles (con el prefijo ROLE_)
        authorities.addAll(userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
                .collect(Collectors.toSet()));
        System.out.println(authorities);
        return new User(userEntity.getUserName(),
                userEntity.getPassword(),

                true,
                true,
                true,
                true,authorities);
    }
}
