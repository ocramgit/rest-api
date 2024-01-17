package com.mindera.users.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found.");
    }
}
