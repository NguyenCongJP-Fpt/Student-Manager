package com.studentmanager.studentmanager.config;

import com.studentmanager.studentmanager.entity.Student;
import com.studentmanager.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Student student = studentRepository.findById(Integer.parseInt(name)).orElse(null);
        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }
        UserDetails user =
                User.builder()
                        .username(student.getEmail())
                        .password(student.getPassword())
                        .roles("USER")
                        .build();
        return user;
    }
}
