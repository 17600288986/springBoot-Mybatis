package com.forezp.entity;

public class Student {
    String id;
    String stuName;
    String age;
    String sex;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", performance='" + performance + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    String performance;
}
