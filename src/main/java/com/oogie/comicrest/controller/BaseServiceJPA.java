package com.oogie.comicrest.controller;

import javax.persistence.EntityManager;

public class BaseServiceJPA {
    protected final EntityManager entityManager;

    public BaseServiceJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
