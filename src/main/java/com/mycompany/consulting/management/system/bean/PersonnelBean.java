package com.mycompany.consulting.management.system.bean;

public class PersonnelBean {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String role;
    private int salary;
    private boolean isWorking;

    public PersonnelBean(int id, String name, String surname, String email,
                         String password, String role, int salary, boolean isWorking) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.salary = salary;
        this.isWorking = isWorking;
    }

    public PersonnelBean() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    @Override
    public String toString() {
        return "\n" + "name: " + name +
                " surname: " + surname +
                " email: " + email +
                " password: " + password +
                " role: " + role +
                " salary: " + salary +
                " isWorking: " + isWorking;
    }
}