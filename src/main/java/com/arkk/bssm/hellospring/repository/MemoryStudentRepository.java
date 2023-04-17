package com.arkk.bssm.hellospring.repository;

import com.arkk.bssm.hellospring.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryStudentRepository implements StudentRepository {
    private static Map<Long, Student> store = new HashMap<>();

    @Override
    public Long save(Student student) {
        store.put(student.getId(), student);
        return student.getId();
    }

    @Override
    public Student findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }


}
