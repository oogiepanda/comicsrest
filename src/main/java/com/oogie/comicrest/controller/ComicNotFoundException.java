package com.oogie.comicrest.controller;

public class ComicNotFoundException extends RuntimeException{
    ComicNotFoundException(Integer id) {
        super("Could not find comiclist " + id);
    }
}
