package com.zuyd.fict.opendag.data.repository;

import com.zuyd.fict.opendag.model.ScheduleItem;

import java.util.List;
import java.util.Map;

/**
 * Created by Kaj on 18-9-13.
 */
public interface IScheduleItemRepository {

    public void add(ScheduleItem item);

    public void add(List<ScheduleItem> items);

    public Map<Integer, ScheduleItem> getAll();

    public ScheduleItem getById(int id);

    public boolean remove(int id);

}
