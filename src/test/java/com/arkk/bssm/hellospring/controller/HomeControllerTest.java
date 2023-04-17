package com.arkk.bssm.hellospring.controller;

import com.arkk.bssm.hellospring.domain.Student;
import com.arkk.bssm.hellospring.repository.MemoryStudentRepository;
import com.arkk.bssm.hellospring.service.StudentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
//@SpringBootTest
public class HomeControllerTest {
    StudentService service;
    MemoryStudentRepository repository;

//    @Autowired
//    MockMvc mvc;

    @Before
    public void beforeEach() {
        System.out.println("테스트 시작");
        repository = new MemoryStudentRepository();
        service = new StudentService(repository);
    }

    @After
    public void afterEach() {
        System.out.println("테스트 끝");
    }

//    @Test
//    public void hello가반환되도록() throws Exception {
//        String result = "hello";
//
//        mvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(result));
//    }

    @Test
    public void 학생등록() throws Exception {
        //repository = new MemoryStudentRepository();
        //service = new StudentService(repository);
        Student student = new Student();
        student.setId(1234L);
        student.setName("홍길동");
        // System.out.println(service);
        service.edit(student);
    }
}