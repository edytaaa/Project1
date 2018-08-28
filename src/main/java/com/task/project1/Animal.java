package com.task.project1;

public class Animal {
    private Long id;
    private String name;
    private String desc;
    private String img;

    public Animal() {}

    public Animal(Long id, String name, String desc, String img) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

