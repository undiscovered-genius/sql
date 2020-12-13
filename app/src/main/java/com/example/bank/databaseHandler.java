package com.example.bank;

public class databaseHandler {

    int id;
    String name;
    String email;
    String crn_bln;

    public databaseHandler() {
    }

    public String getEmail(){
        return  String.valueOf(email);
    }

    public String getCrn_bln(){
        return String.valueOf(crn_bln);
    }

    public void setEmail(String email) {
        this.email = String.valueOf(email);
    }

    public void setCrn_bln(String crn_bln) {
        this.crn_bln = String.valueOf(crn_bln);
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

    public databaseHandler (int id, String name, String email, String crn_bln) {
        this.id=id;
        this.name=String.valueOf(name);
        this.email = String.valueOf(email);
        this.crn_bln = String.valueOf(crn_bln);
    }

    public databaseHandler (int id, String name) {
        this.id=id;
        this.name=String.valueOf(name);
    }

    public databaseHandler( String name) {
        this.name=name;
    }

    public databaseHandler (String name, String email, String crn_bln){
        this.name=String.valueOf(name);
        this.email = String.valueOf(email);
        this.crn_bln = String.valueOf(crn_bln);
    }

    public databaseHandler (String name, String crn_bln){
        this.name=String.valueOf(name);
        this.crn_bln = String.valueOf(crn_bln);
    }


}
