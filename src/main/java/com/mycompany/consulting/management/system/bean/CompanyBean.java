package com.mycompany.consulting.management.system.bean;

public class CompanyBean {

    public CompanyBean(int id, String name, String sector) {
        this.id = id;
        this.name = name;
        this.sector = sector;
    }

    private int id;
    private String name;
    private String sector;

    public CompanyBean() {
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return name;
    }
}
