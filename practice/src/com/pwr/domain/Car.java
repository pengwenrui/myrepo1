package com.pwr.domain;

public class Car {
    private String type;
    private int id;
    private String  name;
    private int size;
    private int price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
