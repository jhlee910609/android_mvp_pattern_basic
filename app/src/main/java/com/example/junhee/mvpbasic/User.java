package com.example.junhee.mvpbasic;

/**
 * Created by JunHee on 2017. 12. 10..
 */

public class User {

    private int id;
    private String firstName;
    private String LastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        LastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }
}
