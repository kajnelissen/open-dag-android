package com.zuyd.fict.opendag.data.repository;

import com.zuyd.fict.opendag.model.Photo;

import java.util.List;
import java.util.Map;

/**
 * Created by Kaj on 22-10-13.
 */
public interface IPhotoRepository {

    public void add(Photo item);

    public void add(List<Photo> items);

    public Map<Integer, Photo> getAll();

    public Photo getById(int id);

    public boolean remove(int id);

}
