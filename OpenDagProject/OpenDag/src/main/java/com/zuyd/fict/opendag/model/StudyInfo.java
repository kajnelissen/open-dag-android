package com.zuyd.fict.opendag.model;

public class StudyInfo extends Entity {

    private String _title;

    private String _content;

    private int _studyId;

    public StudyInfo(int id, String title, String content, int studyId) {
        super(id);
        this.setTitle(title);
        this.setContent(content);
        this.setStudyId(studyId);
    }

    public String getTitle() {
        return this._title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public String getContent() {
        return this._content;
    }

    public void setContent(String content) {
        this._content = content;
    }

    public int getStudyId() {
        return this._studyId;
    }

    public void setStudyId(int studyId) {
        this._studyId = studyId;
    }

}

