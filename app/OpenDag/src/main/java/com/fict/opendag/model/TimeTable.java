package com.fict.opendag.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaj on 21-10-13.
 */
public class TimeTable {

    // These are sessions that don't last the whole day
    private List<ScheduleItem> _partial;

    // These are sessions that last the whole day
    private List<ScheduleItem> _day;

    public TimeTable() {
        this._partial = new ArrayList<ScheduleItem>();
        this._day = new ArrayList<ScheduleItem>();
    }

    public TimeTable(List<ScheduleItem> items) {
        this._partial = new ArrayList<ScheduleItem>();
        this._day = new ArrayList<ScheduleItem>();
        for ( ScheduleItem item : items ) {
            this._day.add(item);
        }
    }

    public List<ScheduleItem> getAll() {
        List<ScheduleItem> ret = this.getPartial();
        ret.addAll(this.getDay());
        return ret;
    }

    public List<ScheduleItem> getPartial() {
        return this._partial;
    }

    public void addPartial(ScheduleItem item) {
        this._partial.add(item);
    }

    public List<ScheduleItem> getDay() {
        return this._day;
    }

    public void addDay(ScheduleItem item) {
        this._day.add(item);
    }

}
