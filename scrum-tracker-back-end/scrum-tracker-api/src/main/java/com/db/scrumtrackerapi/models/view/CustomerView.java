package com.db.scrumtrackerapi.models.view;

public class CustomerView {
    private String name;
    private String lastName;
    private String email;
    private String role;

    public CustomerView(String name, String lastName, String email, String role) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

}
