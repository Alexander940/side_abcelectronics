package com.icesi.ABCElectronics.entity.mongo;

public class Couple {

    private String name;
    private String data;

    public Couple(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
