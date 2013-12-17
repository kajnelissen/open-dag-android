package com.zuyd.fict.opendag.model;

import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.data.IEntityManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kaj on 7-10-13.
 */
public class SurveySession {

    private static SurveySession ourInstance = new SurveySession();

    private HashMap<Integer, Boolean> _answers;

    public static SurveySession getInstance() {
        return ourInstance;
    }

    private SurveySession() {
        this._answers = new HashMap<Integer, Boolean>();
    }

    private SurveySession(ArrayList<Integer> qIds) {
        this._answers = new HashMap<Integer, Boolean>();
        for ( int i : qIds ) {
            this._answers.put(i, null);
        }
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
        IEntityManager em = EntityManager.getInstance();
        if ( this._answers.isEmpty() || this._answers.entrySet().size() != em.questions().getAll().size() ) {
            return false;
        }
        for ( Map.Entry<Integer, Boolean> answer : this._answers.entrySet() ) {
            if ( answer.getValue() == null ) {
                return false;
            }
        }
        return true;
    }

    public int getScore() {
        if ( !this.isCompleted() ) {
            return -1;
        } else {
            int score = 0;
            for ( Boolean answer : this._answers.values() ) {
                if ( answer == Boolean.TRUE ) {
                    score++;
                }
            }
            return score;
        }
    }

}
