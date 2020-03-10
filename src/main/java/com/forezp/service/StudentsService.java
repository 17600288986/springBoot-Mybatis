package com.forezp.service;


import com.forezp.dao.StudentMapper;
import com.forezp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    @Autowired
    StudentMapper studentMapper;

    public Student findStudentsById(String id) {

        return studentMapper.findStudentsById(id);
    }
}
