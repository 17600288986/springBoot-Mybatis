package com.forezp.service;


import com.forezp.dao.ClassNameMapper;
import com.forezp.entity.ClassName;
import com.forezp.utils.ReflectUtil;
import jdk.internal.dynalink.support.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class ClassService {

    @Autowired
    private ClassNameMapper classNameMapper;

    @Autowired
    private ReflectUtil reflectUtil;

    public Map<String, Object> findClassByid(String id) {
        ClassName classById = classNameMapper.findClassById(id);

        Map<String, Object> map = ReflectUtil.beanToMap(classById);
        return map;
    }

}
