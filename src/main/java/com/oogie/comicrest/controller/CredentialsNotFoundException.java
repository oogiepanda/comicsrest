package com.oogie.comicrest.controller;

public class CredentialsNotFoundException extends RuntimeException{
    CredentialsNotFoundException(Integer id) {
        super("Could not find credentials " + id);
    }
}
