package com.zuyd.fict.opendag;

import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
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
import android.webkit.WebView;
import android.widget.TextView;

import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.data.IEntityManager;
import com.zuyd.fict.opendag.model.ScheduleItem;
import com.zuyd.fict.opendag.model.Study;

public class StudyInfoActivity extends BaseActivity {

//    private TextView _txtTitle, _txtDescription, _txtLocation, _txtStart, _txtEnd, _txtSpeaker;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IEntityManager em = EntityManager.getInstance();

        setContentView(R.layout.activity_study_info);

        Intent intent = getIntent();
        int id = intent.getIntExtra("item_id", 1);
        Study item = em.studies().getById(id);

        this.webView = (WebView) findViewById(R.id.webView);
        this.webView.loadData(item.getInformation().getContent(), "text/html", "UTF-8");

//        this._txtTitle = (TextView) findViewById(R.id.schedule_item_title);
//        this._txtTitle.setText(item.getTitle());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.schedule_item, menu);
        return true;
    }

}
