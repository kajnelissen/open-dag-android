package com.zuyd.fict.opendag;

import java.util.Locale;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.data.IEntityManager;
import com.zuyd.fict.opendag.model.Question;
import com.zuyd.fict.opendag.model.SurveySession;

public class SurveyActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.survey, menu);
        return true;
    }
    
    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            Fragment fragment = new QuestionSectionFragment();
            Bundle args = new Bundle();
            args.putInt(QuestionSectionFragment.ARG_QUESTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            IEntityManager em = EntityManager.getInstance();
            return em.questions().getAll().size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            Locale l = Locale.getDefault();
//            switch (position) {
//                case 0:
//                    return getString(R.string.title_section1).toUpperCase(l);
//                case 1:
//                    return getString(R.string.title_section2).toUpperCase(l);
//                case 2:
//                    return getString(R.string.title_section3).toUpperCase(l);
//            }
//            return null;
            return "VRAAG " + (position + 1);
        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_SECTION_NUMBER = "section_number";

        public DummySectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_survey_dummy, container, false);
            TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
            dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public static class QuestionSectionFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        public static final String ARG_QUESTION_NUMBER = "question_number";
        public static final String ARG_QUESTION_ID = "question_id";

        private int _qId;

        public QuestionSectionFragment() {
        }

//        public QuestionSectionFragment(int questionId) {
//            this._qId = questionId;
//        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_question, container, false);

            IEntityManager em = EntityManager.getInstance();
//            Question q = em.questions().getById(this._qId);
            Question q = em.questions().getAtPosition(getArguments().getInt(ARG_QUESTION_NUMBER) - 1);

            TextView number = (TextView) rootView.findViewById(R.id.txtQuestionNumber);
            number.setText("Vraag " + Integer.toString(getArguments().getInt(ARG_QUESTION_NUMBER)));

            TextView question = (TextView) rootView.findViewById(R.id.txtQuestionText);
            question.setText(q.getText());

            Button btnTrue = (Button) rootView.findViewById(R.id.btnQuestionTrue);
            if ( q.getAnswer() == Boolean.TRUE ) {
                btnTrue.setBackgroundColor(Color.GREEN);
            }
            btnTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IEntityManager em = EntityManager.getInstance();
                    Question q = em.questions().getAtPosition(getArguments().getInt(ARG_QUESTION_NUMBER) - 1);
                    q.setAnswer(Boolean.TRUE);
                    SurveySession ss = SurveySession.getInstance();
                    ss.addAnswer(q.getId(), Boolean.TRUE);
                    v.setBackgroundColor(Color.GREEN);
                    isCompleted();
                }
            });

            Button btnFalse = (Button) rootView.findViewById(R.id.btnQuestionFalse);
            if ( q.getAnswer() == Boolean.FALSE ) {
                btnFalse.setBackgroundColor(Color.RED);
            }
            btnFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IEntityManager em = EntityManager.getInstance();
                    Question q = em.questions().getAtPosition(getArguments().getInt(ARG_QUESTION_NUMBER) - 1);
                    q.setAnswer(Boolean.FALSE);
                    SurveySession ss = SurveySession.getInstance();
                    ss.addAnswer(q.getId(), Boolean.FALSE);
                    v.setBackgroundColor(Color.RED);
                    isCompleted();
                }
            });

            return rootView;
        }

        private void isCompleted() {
            SurveySession ss = SurveySession.getInstance();
            if ( ss.isCompleted() ) {
                Intent intent = new Intent(getActivity(), SurveyResultActivity.class);
                startActivity(intent);
            }
        }
    }

}
