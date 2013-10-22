package com.zuyd.fict.opendag.model;

public class StudyInfo {

    private int id;

    private String title;

    private String content;

    private int studyId;

    public StudyInfo() {

    }

    public StudyInfo(int id, String title, String content, int studyId) {
        this.setId(id);
        this.setTitle(title);
        this.setContent(content);
        this.setStudyId(studyId);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStudyId() {
        return this.studyId;
    }

    public void setStudyId(int studyId) {
        this.studyId = studyId;
    }

}

