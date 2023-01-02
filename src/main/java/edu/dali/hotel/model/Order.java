package edu.dali.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private String name;
    private String bTime;
    private String aTime;
    private String phone;
    private String oldPhone;
    private String email;
    private List<Room> ordrooms = new ArrayList<>();
    private List<String> ordnums = new ArrayList<>();

    public Order() {
    }

    public Order(int id, String name, String bTime, String aTime, String phone, String oldPhone, String email, List<Room> ordrooms, List<String> ordnums) {
        this.id = id;
        this.name = name;
        this.bTime = bTime;
        this.aTime = aTime;
        this.phone = phone;
        this.oldPhone = oldPhone;
        this.email = email;
        this.ordrooms = ordrooms;
        this.ordnums = ordnums;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bTime='" + bTime + '\'' +
                ", aTime='" + aTime + '\'' +
                ", phone='" + phone + '\'' +
                ", oldPhone='" + oldPhone + '\'' +
                ", email='" + email + '\'' +
                ", ordrooms=" + ordrooms +
                '}';
    }


    public List<Room> getOrdrooms() {
        return ordrooms;
    }

    public void setOrdrooms(List<Room> ordrooms) {
        this.ordrooms = ordrooms;
    }

    public List<String> getOrdnums() {
        return ordnums;
    }

    public void setOrdnums(List<String> ordnums) {
        this.ordnums = ordnums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String getaTime() {
        return aTime;
    }

    public void setaTime(String aTime) {
        this.aTime = aTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOldPhone() {
        return oldPhone;
    }

    public void setOldPhone(String oldPhone) {
        this.oldPhone = oldPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
