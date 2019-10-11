package com.studentmanager.studentmanager.repository;

import com.studentmanager.studentmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor<Student> {

    @Query("select h from Student as h where h.status = :status")
    List<Student> findActiveStudent(@Param("status") int status);

    List<Student> findAllByStatus(int status);

}
