package edu.dali.hotel.model;

/**
 * @author z360-y
 * @create 2022-11-08  12:21
 */


public class User {


    private String name;
    private String password;
    private String sex;
    private String where;
    private String id;
    private String Type;
    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public User(String name, String password, String sex, String where, String id, String type) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.where = where;
        this.id = id;
        Type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", where='" + where + '\'' +
                ", id='" + id + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
