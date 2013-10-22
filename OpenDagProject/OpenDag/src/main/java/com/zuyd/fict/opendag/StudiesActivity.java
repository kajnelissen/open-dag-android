package com.zuyd.fict.opendag;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.model.Study;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class StudiesActivity extends BaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies);

        this.listView = (ListView) findViewById(R.id.studiesList);

        EntityManager em = EntityManager.getInstance();

        this.listView = (ListView) findViewById(R.id.studiesList);
        Map<Integer, Study> test = em.studies().getAll();
        this.listView.setAdapter(new StudyListAdapter(this, em.studies().getAll()));

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Study item = (Study) listView.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), StudyInfoActivity.class);
                intent.putExtra("item_id", item.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.studies, menu);
        return true;
    }
    
}
