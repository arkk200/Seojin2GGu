package com.arkk.bssm.hellospring.repository;

import com.arkk.bssm.hellospring.domain.Student;

import java.util.List;

public interface StudentRepository {

    Long save(Student student);

    Student findById(Long id);

    List<Student> findAll();
}
