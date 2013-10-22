package com.fict.opendag.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kaj on 7-10-13.
 */
public class StudyQuizSession {

    private static StudyQuizSession ourInstance = new StudyQuizSession();

    private StudyQuiz _quiz = null;

    private HashMap<Integer, Boolean> _answers;

    public static StudyQuizSession getInstance() {
        return ourInstance;
    }

    private StudyQuizSession() {
        this._answers = new HashMap<Integer, Boolean>();
    }

    private StudyQuizSession(ArrayList<Integer> qIds) {
        this._answers = new HashMap<Integer, Boolean>();
        for ( int i : qIds ) {
            this._answers.put(i, null);
        }
    }

    public void setStudyQuiz(StudyQuiz quiz) {
        this._quiz = quiz;
    }

    public StudyQuiz getStudyQuiz() {
        return this._quiz;
    }

    public void addAnswer(int qId, boolean answer) {
        this._answers.put(qId, answer);
    }

    public Boolean getAnswer(int qId) {
        if ( this._answers.containsKey(qId) ) {
            return this._answers.get(qId);
        }
        return null;
    }

    public HashMap<Integer, Boolean> getAnswers() {
        return this._answers;
    }

    public boolean isCompleted() {
        if ( this._answers.isEmpty() || this._answers.entrySet().size() != this._quiz.getQuestions().size() ) {
            return false;
        }
        for ( Map.Entry<Integer, Boolean> answer : this._answers.entrySet() ) {
            if ( answer.getValue() == null ) {
                return false;
            }
        }
        return true;
    }

}
