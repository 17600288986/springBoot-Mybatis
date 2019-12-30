package com.forezp.web;

import com.forezp.entity.ClassName;
import com.forezp.service.ClassService;
import com.forezp.utils.ResultUtil;
import com.forezp.vo.Result;
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


    @RequestMapping(value = "/findClassByid", method = RequestMethod.GET)
    public Result findClassByid(String id){
        ResultUtil resultUtil = new ResultUtil<>();
        Result result;
        try {
            ClassName className = classService.findClassByid(id);
            result= resultUtil.setData(className);
        } catch (Exception e) {
            e.printStackTrace();

            result=resultUtil.setErrorMsg("查询班级失败");
        }

        return result;
    }

}
