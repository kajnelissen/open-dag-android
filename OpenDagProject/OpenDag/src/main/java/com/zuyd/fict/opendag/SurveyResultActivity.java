package com.zuyd.fict.opendag;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.data.IEntityManager;
import com.zuyd.fict.opendag.model.SurveySession;

public class SurveyResultActivity extends Activity {

    private TextView _txtScore;
    private TextView _txtScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_result);

        this._txtScore = (TextView) findViewById(R.id.txtScore);
        this._txtScoreText = (TextView) findViewById(R.id.txtScoreText);

        SurveySession ss = SurveySession.getInstance();
        if ( ss.isCompleted() ) {
            this._txtScore.setText(Integer.toString(ss.getScore()));
            this._txtScoreText.setText(this.getScoreText());
        }
    }

    private String getScoreText() {
        SurveySession ss = SurveySession.getInstance();
        IEntityManager em = EntityManager.getInstance();
        int score = ss.getScore();
        int nrQuestions = em.questions().getAll().size();
//        int percentage = (score / nrQuestions) * 100;
//        double percentage = Math.ceil((ss.getScore() / em.questions().getAll().size()) * 100);
        if ( score > nrQuestions * 0.8 ) {
            return "Je hebt duidelijk interesse in het vakgebied ICT! ICT aan Zuyd Hogeschool past wel bij je!";
        } else if ( score > nrQuestions * 0.6 ) {
            return "ICT is wel iets voor jou. Het zou wel eens goede keuze voor je kunnen zijn!";
        } else if ( score > nrQuestions * 0.3 ) {
            return "Je twijfelt nog een beetje. Misschien is het goed wat meer informatie te vergaren over de opleiding.";
        } else {
            return "ICT is niet echt jouw ding. Misschien is het verstandiger een kijkje te gaan nemen bij andere studies of wat meer informatie in te winnen over de opleiding ICT aan Zuyd Hogeschool.";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.survey_result, menu);
        return true;
    }
    
}
