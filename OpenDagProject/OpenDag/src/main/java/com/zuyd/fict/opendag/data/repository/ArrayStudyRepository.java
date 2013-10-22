package com.zuyd.fict.opendag.data.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zuyd.fict.opendag.model.ScheduleItem;
import com.zuyd.fict.opendag.model.Study;
import com.zuyd.fict.opendag.model.StudyQuiz;

/**
 * Created by Kaj on 7-10-13.
 */
public class ArrayStudyRepository implements IStudyRepository {

    private Map<Integer, Study> _items;

    public ArrayStudyRepository() {
        this._items = new HashMap<Integer, Study>();
    }

    public void add(Study item) {
        this._items.put(item.getId(), item);
    }

    public void add(List<Study> items) {
        for ( Study item : items ) {
            this.add(item);
        }
    }


    public Map<Integer, Study> getAll() {
        return this._items;
    }

    /**
     *
     * @param id
     * @return
     */
    public Study getById(int id) {
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
