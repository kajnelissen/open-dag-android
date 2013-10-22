package com.zuyd.fict.opendag.model;

import java.util.ArrayList;

/**
 * Created by Kaj on 30-9-13.
 */
public class StudyQuiz extends Entity {

    private ArrayList<Question> _questions;

    /**
     *
     * @param id
     */
    public StudyQuiz(int id) {
        super(id);
        this._questions = new ArrayList<Question>();
    }

    public StudyQuiz(int id, ArrayList<Question> qs) {
        super(id);
        this._questions = qs;
    }

    public void addQuestion(Question q) {
        this._questions.add(q);
    }

    public ArrayList<Question> getQuestions() {
        return this._questions;
    }

}
