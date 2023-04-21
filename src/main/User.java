/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author MY-PC
 */
class User {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User u = (User) obj;
        if (this.getName().equals(u.getName()) && this.getPassword().equals(u.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        return String.format("%s-%s", this.getName(), this.getPassword());
    }

}
