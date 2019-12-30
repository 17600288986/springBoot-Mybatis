package com.forezp.controller;

import com.forezp.entity.ClassName;
import com.forezp.service.ClassService;
import com.forezp.service.StudentsService;
import com.forezp.utils.ResultUtil;
import com.forezp.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/className")
public class StudentController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/findClassByid", method = RequestMethod.GET)
    public Result findClassByid(@RequestParam ("id") String id){
        ResultUtil resultUtil = new ResultUtil<>();
        Result result;
        ClassName className = classService.findClassByid(id);
        return result= resultUtil.setData(className);
    }

}
