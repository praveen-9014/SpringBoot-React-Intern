package com.example.springbootfirst.services;

import com.example.springbootfirst.jwt.JwtTokenProvider;
import com.example.springbootfirst.models.RegisterDetails;
import com.example.springbootfirst.models.Roles;
import com.example.springbootfirst.models.UserDetailsDto;
import com.example.springbootfirst.repository.RegisterDetailsRepo;
import com.example.springbootfirst.repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RegisterDetailsRepo registerDetailsRepo;

    @Autowired
    RolesRepo rolesRepo;
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    public String addNewEmployee(UserDetailsDto registerDetails){
        RegisterDetails registerDetails1 = new RegisterDetails();

        registerDetails1.setEmpId(registerDetails.getEmpId());
        registerDetails1.setName(registerDetails.getName());
        registerDetails1.setEmail(registerDetails.getEmail());
        registerDetails1.setPassword(passwordEncoder.encode(registerDetails.getPassword()));
        registerDetails1.setUsername(registerDetails.getUsername());
        Set<Roles> roles = new HashSet<>();
        registerDetails1.setRoles(roles);

        for (String roleName : registerDetails.getRoleNames()) {
            Roles role = rolesRepo.findByRoleName(roleName)
                    .orElseGet(() -> {
                        Roles newRole = new Roles();
                        newRole.setRoleName(roleName);
                        return rolesRepo.save(newRole);
                    });
            roles.add(role);
        }



        registerDetailsRepo.save(registerDetails1);

        return "Employee is added sucessfully";
    }

//    public String authenticate(RegisterDetails login) {
//        Optional<RegisterDetails> user = registerDetailsRepo.findByEmail(login.getEmail());
//        if(user.get().getEmail() != null){
//            if(passwordEncoder.matches(login.getPassword(), user.get().getPassword())){
//                return "user login sucessfull";
//            }
//            else{
//                return "Enter the correct password";
//            }
//        }
//        else{
//            return "Enter the correct email";
//        }
//
//
//    }

//    public String authenticate(RegisterDetails login){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        login.getUsername(), login.getPassword())
//                );
//
//        return jwtTokenProvider.generateToken(authentication);
//    }
//
//    public Optional<RegisterDetails> getUserByUsername(String username){
//        return Optional.ofNullable(registerDetailsRepo.findByUsername(username));
//    }
}
