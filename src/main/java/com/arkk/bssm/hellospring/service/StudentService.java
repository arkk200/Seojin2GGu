package com.arkk.bssm.hellospring.service;

import com.arkk.bssm.hellospring.domain.Student;
import com.arkk.bssm.hellospring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Long edit(Student student) {
        // 1. 같은 학번이 있나?
        validateDuplicateStudent(student);
        // 2. 값 저장
        Long input = repository.save(student);
        // System.out.println("input = " + input);
        return input;
    }

    private void validateDuplicateStudent(Student student) {
        // 중복확인
        if (repository.findById(student.getId()) != null) {
            throw new IllegalStateException("이미 등록된 학번입니다.");
        }
    }

    public List<Student> findStudents() {
        return repository.findAll();
    }

    public Long updateScore(Student student) {
        Student update = repository.findById(student.getId());
        update.setScore(student.getScore());

        return update.getId();
    }

    public Student findOne(Long id) {
        return repository.findById(id);
    }
}
