package com.example.bank;

public class databaseHandler {

    int id;
    String name;

    public databaseHandler() {
    }

    public String getName() {
        return String.valueOf(name);
    }

    public void setName(String name) {
        this.name =String.valueOf(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public databaseHandler (int id, String name) {
        this.id=id;
        this.name=String.valueOf(name);
    }

    public databaseHandler( String name) {
        this.name=name;
    }


}
