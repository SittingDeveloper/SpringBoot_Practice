package com.study.springboot;

public class Member { // DTO, 커맨드 객체
    private String id;
    private String name;

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
