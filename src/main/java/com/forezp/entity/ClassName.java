package com.forezp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClassName {
    private String id;
    @NotNull(message = "班级名称不能为空")
    private String className;
    @Size(min = 1, max = 5, message = "姓名长度必须为1到5")
    private String stuName;

    @Transient
    private String sex;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }


}
