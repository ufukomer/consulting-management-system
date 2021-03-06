package com.mycompany.consulting.management.system.bean;

import java.util.Date;

public class ProjectBean {

    private int id;
    private String name;
    private String sector;
    private int minimumPersonelNumber;
    private int maximumPersonelNumber;

    private Date startedDate;
    private Date endedDate;

    private int projectManagerNumber;
    private int analystNumber;
    private int designerNumber;
    private int developerNumber;
    private int testerNumber;

    private boolean readyToStart;

    public ProjectBean() {
    }

    public boolean isReadyToStart() {
        return readyToStart;
    }

    public void setReadyToStart(boolean readyToStart) {
        this.readyToStart = readyToStart;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Date endedDate) {
        this.endedDate = endedDate;
    }

    public int getProjectManagerNumber() {
        return projectManagerNumber;
    }

    public void setProjectManagerNumber(int projectManagerNumber) {
        this.projectManagerNumber = projectManagerNumber;
    }

    public int getAnalystNumber() {
        return analystNumber;
    }

    public void setAnalystNumber(int analystNumber) {
        this.analystNumber = analystNumber;
    }

    public int getDesignerNumber() {
        return designerNumber;
    }

    public void setDesignerNumber(int designerNumber) {
        this.designerNumber = designerNumber;
    }

    public int getDeveloperNumber() {
        return developerNumber;
    }

    public void setDeveloperNumber(int developerNumber) {
        this.developerNumber = developerNumber;
    }

    public int getTesterNumber() {
        return testerNumber;
    }

    public void setTesterNumber(int testerNumber) {
        this.testerNumber = testerNumber;
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
        return "Project{ \n id:" + getId() + "\n" +
                "name: " + getName() + "\n" +
                "sector: " + getSector() + "\n }";
    }
}
