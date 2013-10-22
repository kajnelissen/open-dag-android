package com.zuyd.fict.opendag.data.repository;

import com.zuyd.fict.opendag.model.ScheduleItem;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Kaj on 18-9-13.
 */
public class ArrayScheduleItemRepository implements IScheduleItemRepository {

    private Map<Integer, ScheduleItem> _items;

    public ArrayScheduleItemRepository() {
        this._items = new HashMap<Integer, ScheduleItem>();
    }

    public void add(ScheduleItem item) {
        this._items.put(item.getId(), item);
    }

    public void add(List<ScheduleItem> items) {
        for ( ScheduleItem item : items ) {
            this.add(item);
        }
    }


    public Map<Integer, ScheduleItem> getAll() {
        return this._items;
    }

    /**
     *
     * @param id
     * @return
     */
    public ScheduleItem getById(int id) {
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
