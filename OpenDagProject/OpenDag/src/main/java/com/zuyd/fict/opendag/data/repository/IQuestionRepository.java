package com.zuyd.fict.opendag.data.repository;

import com.zuyd.fict.opendag.model.Question;

import java.util.List;
import java.util.Map;

/**
 * Created by Kaj on 21-10-13.
 */
public interface IQuestionRepository {

    public void add(Question item);

    public void add(List<Question> items);

    public Map<Integer, Question> getAll();

    public Question getById(int id);

    public boolean remove(int id);

    public Question getAtPosition(int position);

}
