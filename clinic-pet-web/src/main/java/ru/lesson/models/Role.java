package ru.lesson.models;

public class Role extends Base {
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        if(name==null || name.isEmpty()){
            name="exception";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}