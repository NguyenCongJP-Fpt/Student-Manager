package com.studentmanager.studentmanager.service;

import com.studentmanager.studentmanager.entity.Student;
import com.studentmanager.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> students() {
        studentRepository.findAll(PageRequest.of(1, 3));
        return studentRepository.findActiveStudent(1);
    }

    public Page<Student> heroesWithPaginate(Specification specification, int page, int limit) {
        return studentRepository.findAll(specification, PageRequest.of(page - 1, limit));
    }

    public Student getById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student create(Student student) {
        student.setStatus(1);
        student.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        student.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        student.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return studentRepository.save(student);
    }

    public boolean delete(Student student) {
        student.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        student.setStatus(-1);
        studentRepository.save(student);
        return true;
    }
}
