package com.fict.opendag.model;

/**
 * Created by Kaj on 7-10-13.
 */
public class Question extends Entity {

    private Boolean _answer;

    private String _text;

    /**
     *
     * @param id
     */
    public Question(int id, String text) {
        super(id);
        this._text = text;
        this.setAnswer(null);
    }

    public void setAnswer(Boolean ans) {
        this._answer = ans;
    }

    public Boolean getAnswer() {
        return this._answer;
    }

    public void setText(String text) {
        this._text = text;
    }

    public String getTest() {
        return this._text;
    }

    public boolean isAnswered() {
        return this._answer != null;
    }

}
