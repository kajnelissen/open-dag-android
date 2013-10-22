package com.zuyd.fict.opendag.data.repository;

import com.zuyd.fict.opendag.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kaj on 21-10-13.
 */
public class ArrayQuestionRepository implements IQuestionRepository {

    private Map<Integer, Question> _items;

    public ArrayQuestionRepository() {
        this._items = new HashMap<Integer, Question>();
    }

    public void add(Question item) {
        this._items.put(item.getId(), item);
    }

    public void add(List<Question> items) {
        for ( Question item : items ) {
            this.add(item);
        }
    }

    public Map<Integer, Question> getAll() {
        return this._items;
    }

    /**
     *
     * @param id
     * @return
     */
    public Question getById(int id) {
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
