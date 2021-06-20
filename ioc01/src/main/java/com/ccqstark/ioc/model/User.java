package com.ccqstark.ioc.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
    private String username;
    private String address;
    private Integer id;
    private Cat cat;
    private Cat[] cats;
    private List<String> favorites;
    private Map<String, Object> details;
    private Properties info;

    public User(){
        System.out.println("-----------init------------");
    }

    public User(String username, String address, Integer id) {
        System.out.println("构造器注入");
        this.username = username;
        this.address = address;
        this.id = id;
    }

    public Cat[] getCats() {
        return cats;
    }

    public void setCats(Cat[] cats) {
        this.cats = cats;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("username = "+username);
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", cat=" + cat +
                ", cats=" + Arrays.toString(cats) +
                ", favorites=" + favorites +
                ", details=" + details +
                ", info=" + info +
                '}';
    }

}
