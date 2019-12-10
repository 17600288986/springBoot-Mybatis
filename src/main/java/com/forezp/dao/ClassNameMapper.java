package com.forezp.dao;


import com.forezp.entity.ClassName;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



public interface  ClassNameMapper {

    @Select("select * from t_class_name where id= #{id}")
    ClassName findClassById( String id);

}
