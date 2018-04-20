package com.kingwanyama.firebase;

/**
 * Created by kingwanyama on 9/29/17.
 */

public class User {

    private String names,email,age;

    public User(String names, String email, String age) {
        this.names = names;
        this.email = email;
        this.age = age;
    }
    public User(){

    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
