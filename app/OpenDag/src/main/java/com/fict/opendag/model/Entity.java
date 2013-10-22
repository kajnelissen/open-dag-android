package com.fict.opendag.model;

/**
 * Created by Kaj on 18-9-13.
 */
public abstract class Entity {

    private int _id;

    public Entity(int id) {
        this._id = id;
    }

    public int getId() {
        return this._id;
    }

}
