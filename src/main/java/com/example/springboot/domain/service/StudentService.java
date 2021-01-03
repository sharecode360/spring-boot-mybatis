package com.example.springboot.domain.service;

import com.example.springboot.domain.model.Student;
import com.example.springboot.domain.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    public List<Student> getStudents(Student student) {
        return studentMapper.getStudents(student);
    }

    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public boolean deleteStudentById(Integer id) {
        return studentMapper.deleteStudentById(id);
    }

}
