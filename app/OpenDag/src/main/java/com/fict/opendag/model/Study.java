package com.fict.opendag.model;

public class Study {

    private int id;

    private String name;

    private String shortName;

    private StudyInfo information;

    public Study() {

    }

    public Study(int id, String name, String shortName, StudyInfo info) {
        this.setId(id);
        this.setName(name);
        this.setShortName(shortName);
        this.setInformation(info);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

