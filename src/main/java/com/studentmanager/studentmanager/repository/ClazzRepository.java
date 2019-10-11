package com.studentmanager.studentmanager.repository;

import com.studentmanager.studentmanager.entity.Clazz;
import com.studentmanager.studentmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClazzRepository extends JpaRepository<Clazz, Integer>, JpaSpecificationExecutor<Student> {

    @Query("select h from Clazz as h where h.status = :status")
    List<Clazz> findActiveClazz(@Param("status") int status);

    List<Clazz> findAllByStatus(int status);

}
