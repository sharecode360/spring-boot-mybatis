package com.example.springboot.controller;

import com.example.springboot.domain.model.Student;
import com.example.springboot.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 指定された学生のIDによって学生情報を返す
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }

    /**
     * 条件を満たした学生情報を取得する
     * @param student
     * @return
     */
    @GetMapping
    public List<Student> getStudents(Student student) {
        return  studentService.getStudents(student);
    }

    /***
     * 学生情報を追加する
     * @param student
     * @return
     */
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        // 追加後のID付の学生を返し
        return student;
    }

    /**
     * 学生情報を更新する
     * @param student
     * @return
     */
    @PutMapping
    public boolean updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    /**
     * 指定した学生のIDによって学生情報を削除する
     * @param id
     * @return
     */
    @DeleteMapping
    public boolean deleteStudentById(@PathVariable("id") Integer id) {
        return studentService.deleteStudentById(id);
    }
}
