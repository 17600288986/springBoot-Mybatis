package com.forezp.web;


import com.forezp.entity.ClassName;
import com.forezp.entity.Student;
import com.forezp.service.ClassService;
import com.forezp.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentsService studentsService;
    @RequestMapping(value = "/findStudentsById", method = RequestMethod.GET)
    public Student findClassByid(String id){
        Student student = studentsService.findStudentsById(id);
        return student;
    }
}
