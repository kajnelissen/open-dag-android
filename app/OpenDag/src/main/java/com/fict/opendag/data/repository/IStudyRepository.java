package com.fict.opendag.data.repository;

import com.fict.opendag.model.Study;
import com.fict.opendag.model.StudyQuiz;

import java.util.List;
import java.util.Map;

/**
 * Created by Kaj on 18-9-13.
 */
public interface IStudyRepository {

    public void add(Study item);

    public void add(List<Study> items);

    public Map<Integer, Study> getAll();

    public Study getById(int id);

    public boolean remove(int id);

}
