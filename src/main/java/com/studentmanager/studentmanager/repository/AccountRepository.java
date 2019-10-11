package com.studentmanager.studentmanager.repository;

import com.studentmanager.studentmanager.entity.Account;
import com.studentmanager.studentmanager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
