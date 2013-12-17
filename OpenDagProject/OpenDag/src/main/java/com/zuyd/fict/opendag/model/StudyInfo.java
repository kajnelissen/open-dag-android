package com.zuyd.fict.opendag.model;

public class StudyInfo extends Entity {

    private String title;

    private String content;

    private int studyId;

    public StudyInfo(int id, String title, String content, int studyId) {
        super(id);
        this.setTitle(title);
        this.setContent(content);
        this.setStudyId(studyId);
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

