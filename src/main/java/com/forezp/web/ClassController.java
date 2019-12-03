package com.forezp.web;

import com.forezp.entity.ClassName;
import com.forezp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;
    @RequestMapping(value = "/findClassByid/{id}", method = RequestMethod.GET)
    public ClassName findClassByid(@PathVariable("id") String id){
        ClassName classByid = classService.findClassByid(id);
        return classByid;
    }

}
