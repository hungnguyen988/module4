package com.example.new_jwt.repository;

import com.example.new_jwt.model.AppUser;
import com.example.new_jwt.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(AppUser appUser);
}
