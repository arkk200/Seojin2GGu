package com.arkk.bssm.hellospring.controller;

import com.arkk.bssm.hellospring.domain.Student;
import com.arkk.bssm.hellospring.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/students/new")
    public String createStudent(StudentForm studentForm) {
        Student student = new Student();
        student.setId(studentForm.getId());
        student.setName(studentForm.getName());
        student.setScore(0L);
        service.edit(student);
        return "redirect:/";
    }

    @GetMapping("/students")
    public String getStudentList(Model model) {
        List<Student> students = service.findStudents();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/students/{id}/input")
    public String updateStudent(@PathVariable Long id, Model model) {
        Student student = service.findOne(id);

        StudentForm form = new StudentForm();
        form.setId(student.getId());
        form.setName(student.getName());
        form.setScore(student.getScore());

        model.addAttribute("form", form);
        return "update";
    }

    @PostMapping("/students/{id}/input")
    public String editStudent(@PathVariable Long id, @ModelAttribute StudentForm form) {
        Student student = new Student();
        student.setId(id);
        student.setScore(form.getScore());

        service.updateScore(student);
        return "redirect:/students";
    }
}
