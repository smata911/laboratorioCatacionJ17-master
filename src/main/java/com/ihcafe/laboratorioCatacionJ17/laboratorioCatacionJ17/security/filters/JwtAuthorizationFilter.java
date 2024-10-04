package com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.security.filters;

import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.security.jwt.JwtUtils;
import com.ihcafe.laboratorioCatacionJ17.laboratorioCatacionJ17.service.implementation.UserDetailServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull  FilterChain filterChain) throws ServletException, IOException {

        String tokenHeader =request.getHeader("Authorization");
        if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")){
            String token=tokenHeader.substring(7);

            if(jwtUtils.isTokenValid(token)){
                String userName=jwtUtils.getUserName(token);
                UserDetails userDetails= userDetailService.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userName,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            }

        }
        filterChain.doFilter(request,response);
    }
}
