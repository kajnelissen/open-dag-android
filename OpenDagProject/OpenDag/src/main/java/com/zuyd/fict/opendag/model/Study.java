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
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public StudyInfo getInformation() {
        return this.information;
    }

    public void setInformation(StudyInfo info) {
        this.information = info;
    }

}

