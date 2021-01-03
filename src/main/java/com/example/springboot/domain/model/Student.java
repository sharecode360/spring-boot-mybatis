package com.example.springboot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable  {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String stuName;

    private String sex;

    private Integer age;
}
