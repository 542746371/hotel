package edu.dali.hotel.model;

/**
 * @author z360-y
 * @create 2022-10-23  10:17
 */


public class Room {

    private int id ;
    private String name;
    private String food;
    private String bed;
    private String wifi;
    private int price;
    private int subprice;


    public Room() {
        super();
    }

    public Room(int id , String name, String food, String bed, String wifi, int price, int subprice) {
        super();
        this.id = id;
        this.name = name;
        this.food = food;
        this.bed = bed;
        this.wifi = wifi;
        this.price = price;
        this.subprice = subprice;

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
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public String getBed() {
        return bed;
    }
    public void setBed(String bed) {
        this.bed = bed;
    }
    public String getWifi() {
        return wifi;
    }
    public void setWifi(String wifi) {
        this.wifi = wifi;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setPrice(String price) {
        this.price = Integer.valueOf(price);
    }
    public int getSubprice() {
        return subprice;
    }
    public void setSubprice(int subprice) {
        this.subprice = subprice;
    }
    public void setSubprice(String subprice) {
        this.subprice =  Integer.valueOf(subprice);
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", food='" + food + '\'' +
                ", bed='" + bed + '\'' +
                ", wifi='" + wifi + '\'' +
                ", price=" + price +
                ", subprice=" + subprice +
                '}';
    }
}
