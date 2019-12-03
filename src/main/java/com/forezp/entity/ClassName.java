package com.forezp.entity;

public class ClassName {
    String id;
    String className;
    String stuName;

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
