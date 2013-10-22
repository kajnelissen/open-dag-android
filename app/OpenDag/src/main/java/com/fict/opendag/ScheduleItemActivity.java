package com.fict.opendag;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

import com.fict.opendag.data.EntityManager;
import com.fict.opendag.data.IEntityManager;
import com.fict.opendag.model.ScheduleItem;

public class ScheduleItemActivity extends Activity {

    private TextView _txtTitle, _txtDescription, _txtLocation, _txtStart, _txtEnd, _txtSpeaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IEntityManager em = EntityManager.getInstance();

        setContentView(R.layout.activity_schedule_item);

        Intent intent = getIntent();
        int id = intent.getIntExtra("item_id", 1);
        ScheduleItem item = em.scheduleItems().getById(id);

        this._txtTitle = (TextView) findViewById(R.id.schedule_item_title);
        this._txtTitle.setText(item.getTitle());
        this._txtDescription = (TextView) findViewById(R.id.schedule_item_description);
        this._txtDescription.setText(item.getDescription());
        this._txtLocation = (TextView) findViewById(R.id.schedule_item_location);
        this._txtLocation.setText(item.getLocation());
        this._txtStart = (TextView) findViewById(R.id.schedule_item_starttime);
        this._txtStart.setText(item.getStartTime());
        this._txtEnd = (TextView) findViewById(R.id.schedule_item_endtime);
        this._txtEnd.setText(item.getEndTime());
        this._txtSpeaker = (TextView) findViewById(R.id.schedule_item_speaker);
        this._txtSpeaker.setText(item.getSpeaker());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.schedule_item, menu);
        return true;
    }
    
}
