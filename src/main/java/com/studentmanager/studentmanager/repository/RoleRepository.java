package com.studentmanager.studentmanager.repository;

import com.studentmanager.studentmanager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
