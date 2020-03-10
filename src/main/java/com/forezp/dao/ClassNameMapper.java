package com.forezp.dao;


import com.forezp.entity.ClassName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassNameMapper {

    @Select("select * from t_class_name where id= #{id}")
    ClassName findClassById(String id);

    @Insert("insert into t_class_name(className, stuName) values(#{className}, #{stuName})")
    void creatClass(@Param("className") String className, @Param("stuName") String stuName);

}
