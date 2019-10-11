package com.studentmanager.studentmanager.service;

import com.studentmanager.studentmanager.entity.Clazz;
import com.studentmanager.studentmanager.entity.Student;
import com.studentmanager.studentmanager.repository.ClazzRepository;
import com.studentmanager.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ClazzService {

    @Autowired
    ClazzRepository clazzRepository;

    public List<Clazz> clazzes() {
        clazzRepository.findAll(PageRequest.of(1, 3));
        return clazzRepository.findActiveClazz(1);
    }

    public Page<Clazz> heroesWithPaginate(Specification specification, int page, int limit) {
        return clazzRepository.findAll(specification, PageRequest.of(page - 1, limit));
    }

    public Clazz getById(int id) {
        return clazzRepository.findById(id).orElse(null);
    }

    public Clazz create(Clazz clazz) {
        clazz.setStatus(1);
        clazz.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        clazz.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return clazzRepository.save(clazz);
    }

    public Clazz update(Clazz clazz) {
        clazz.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return clazzRepository.save(clazz);
    }

    public boolean delete(Clazz clazz) {
        clazz.setDeletedAt(Calendar.getInstance().getTimeInMillis());
        clazz.setStatus(-1);
        clazzRepository.save(clazz);
        return true;
    }
}
