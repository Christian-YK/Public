package com.mayikt.entity;

public class UserEntity {
    //用户ID
    private Long id;
    private String name;
    private String pwd;

    public UserEntity(Long id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public UserEntity(String name,  String pwd) {
        this.name = name;

        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
