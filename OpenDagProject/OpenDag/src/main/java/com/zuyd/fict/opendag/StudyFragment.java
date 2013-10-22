package com.zuyd.fict.opendag;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.zuyd.fict.opendag.R;
import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.model.Study;

public class StudyFragment extends Fragment {

    private int _studyId;

    public StudyFragment(int id) {
        this._studyId = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        EntityManager em = EntityManager.getInstance();
        Study study = em.studies().getById(this._studyId);

        View rootView = inflater.inflate(R.layout.fragment_study, container, false);

//        WebView webview = (WebView) view

        return rootView;
    }
    
}
