package com.fict.opendag.model;

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
        this._startTime = start;
        this._endTime = end;
        this._title = title;
        this._location = location;
        this._description = description;
        this._speaker = speaker;
        this._isDay = isDay;
    }

    public String getStartTime() {
        return this._startTime;
    }

    public String getEndTime() {
        return this._endTime;
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
