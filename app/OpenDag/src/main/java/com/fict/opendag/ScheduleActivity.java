package com.fict.opendag;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fict.opendag.data.EntityManager;
import com.fict.opendag.data.IEntityManager;
import com.fict.opendag.model.ScheduleItem;

import java.util.Map;

public class ScheduleActivity extends BaseActivity {

//    IEntityManager _em;

    ListView _scheduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int pid = android.os.Process.myPid();

        EntityManager em = EntityManager.getInstance();

        setContentView(R.layout.activity_schedule);

        this._scheduleList = (ListView) findViewById(R.id.schedule_list);
        Map<Integer, ScheduleItem> test =em.scheduleItems().getAll();
        this._scheduleList.setAdapter(new ScheduleListAdapter(this, em.scheduleItems().getAll()));

        this._scheduleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ScheduleItem item = (ScheduleItem) _scheduleList.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), ScheduleItemActivity.class);
                intent.putExtra("item_id", item.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.schedule, menu);
        return true;
    }
    
}
