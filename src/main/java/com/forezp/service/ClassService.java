package com.forezp.service;


import com.forezp.dao.ClassNameMapper;
import com.forezp.entity.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    ClassNameMapper classNameMapper;

    public ClassName findClassByid(String id){
        ClassName classById = classNameMapper.findClassById(id);
        return classById;
    }
}
