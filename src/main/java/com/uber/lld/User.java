package com.uber.lld;

/**
 * general User class
 * contains all information specific to a particular user
 */
public abstract class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
}
