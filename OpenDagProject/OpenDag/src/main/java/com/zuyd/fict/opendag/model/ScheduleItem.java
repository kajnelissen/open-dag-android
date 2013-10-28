package com.zuyd.fict.opendag.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kaj on 16-9-13.
 */
public class ScheduleItem extends Entity {

    private String _startTime;

    private String _endTime;

    private String _title;

    private String _location;

    private String _description;

    private String _speaker;

    private boolean _isDay;

    public ScheduleItem(int id, String start, String end, String title, String location, String description, String speaker, boolean isDay) {
        super(id);
        this.setStartTime(start);
        this.setEndTime(end);
        this._title = title;
        this._location = location;
        this._description = description;
        this._speaker = speaker;
        this._isDay = isDay;
    }

    public String getStartTime() {
        return this._startTime;
    }

    public void setStartTime(String time) {
        // dirty trick
        // ignore the first 11 characters of the datetime string
        this._startTime = time.substring(11, 16);
    }

    public String getEndTime() {
        return this._endTime;
    }

    public void setEndTime(String time) {
        // dirty trick
        // ignore the first 11 characters of the datetime string
        this._endTime = time.substring(11, 16);
    }

    public String getTitle() {
        return this._title;
    }

    public String getLocation() {
        return this._location;
    }

    public String getDescription() {
        return this._description;
    }

    public String getSpeaker() {
        return this._speaker;
    }

    public boolean getIsDay() {
        return this._isDay;
    }

}
