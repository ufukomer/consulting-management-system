/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.consulting.management.system.bean;

/**
 *
 * @author Ufuk
 */
public class ProjectBean {
    
    private int id;
    private String name;
    private String sector;
    private int minimumPersonelNumber;
    private int maximumPersonelNumber;

    public ProjectBean() {
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

    public int getMinimumPersonelNumber() {
        return minimumPersonelNumber;
    }

    public void setMinimumPersonelNumber(int minimumPersonelNumber) {
        this.minimumPersonelNumber = minimumPersonelNumber;
    }

    public int getMaximumPersonelNumber() {
        return maximumPersonelNumber;
    }

    public void setMaximumPersonelNumber(int maximumPersonelNumber) {
        this.maximumPersonelNumber = maximumPersonelNumber;
    }

    @Override
    public String toString() {
        return "Project{ \n id:"+getId()+"\n"+
                "name: "+getName()+"\n"+
                "sector: "+getSector()+"\n }";
    }
    
}
