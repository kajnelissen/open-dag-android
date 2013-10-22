package com.zuyd.fict.opendag.data.repository;

import com.zuyd.fict.opendag.model.Photo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kaj on 22-10-13.
 */
public class ArrayPhotoRepository implements IPhotoRepository {

    private Map<Integer, Photo> _items;

    public ArrayPhotoRepository() {
        this._items = new HashMap<Integer, Photo>();
    }

    public void add(Photo item) {
        this._items.put(item.getId(), item);
    }

    public void add(List<Photo> items) {
        for ( Photo item : items ) {
            this.add(item);
        }
    }

    public Map<Integer, Photo> getAll() {
        return this._items;
    }

    /**
     *
     * @param id
     * @return
     */
    public Photo getById(int id) {
        if ( this._items.containsKey(id) ) {
            return this._items.get(id);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean remove(int id) {
        if ( this._items.containsKey(id) ) {
            this._items.remove(id);
            return true;
        }
        return false;
    }

}
