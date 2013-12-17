package com.zuyd.fict.opendag.model;

public class Study extends Entity {

    private String _name;

    private String _shortName;

    private StudyInfo _information;

    public Study(int id, String name, String shortName, StudyInfo info) {
        super(id);
        this.setName(name);
        this.setShortName(shortName);
        this.setInformation(info);
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getShortName() {
        return this._shortName;
    }

    public void setShortName(String shortName) {
        this._shortName = shortName;
    }

    public StudyInfo getInformation() {
        return this._information;
    }

    public void setInformation(StudyInfo info) {
        this._information = info;
    }

}

