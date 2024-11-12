package com.mayikt.entity;

public class StudentEntity {
    /**
     *  学生对象
     *  在JAVA中定义数据库实体类型
     *  不建议使用基本数据类型 应该使用包装类
     */
      private Long id;

      private String name;

      private Integer age;

      private String address;

    public StudentEntity(Long id, String name, Integer age, String address) {
          super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }




}
