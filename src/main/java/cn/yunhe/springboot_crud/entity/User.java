package cn.yunhe.springboot_crud.entity;

public class User {

    private String username;
    private Integer age;
    private String sex;

    public User(String username, Integer age, String sex) {
        this.username = username;
        this.age = age;
        this.sex = sex;
    }

    public User() {

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
