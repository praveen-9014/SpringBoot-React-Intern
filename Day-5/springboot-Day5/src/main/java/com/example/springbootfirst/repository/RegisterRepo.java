package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepo extends JpaRepository<UserDetails, Integer> {

}
