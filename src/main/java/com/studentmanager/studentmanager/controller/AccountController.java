package com.studentmanager.studentmanager.controller;

import com.studentmanager.studentmanager.entity.Account;
import com.studentmanager.studentmanager.entity.Role;
import com.studentmanager.studentmanager.repository.AccountRepository;
import com.studentmanager.studentmanager.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "/home"})
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        Role role = roleRepository.findById(3).orElse(null);
        role.setName("ADMIN");

        Account account = new Account();
        account.setEmail("conghero@gmail.com");
        account.setPassword(passwordEncoder.encode("123"));
        account.setStatus(1);

        role.addAccount(account);

        roleRepository.save(role);
        return "student/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }
}
