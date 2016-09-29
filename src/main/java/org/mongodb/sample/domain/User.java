package org.mongodb.sample.domain;

/**
 * Created by bapaydin on 29.09.2016.
 */
public class User {

    private int id;
    private String name;
    private String role;
    private boolean isEmployee;

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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isEmployee() {
        return isEmployee;
    }
    public void setEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }
}