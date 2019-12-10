package com.forezp.dao;


import com.forezp.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


public interface StudentMapper {

    @Select("select * from t_student where id=#{id}")
    Student findStudentsById(String id);

}
