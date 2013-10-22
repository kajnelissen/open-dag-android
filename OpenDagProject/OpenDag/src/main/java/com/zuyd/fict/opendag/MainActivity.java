package com.zuyd.fict.opendag;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.zuyd.fict.opendag.model.HomeScreenItem;
import com.zuyd.fict.opendag.model.HomeScreenItemType;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ListView _listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this._listView = (ListView) findViewById(R.id.listView);

        ArrayList<HomeScreenItem> items = new ArrayList<HomeScreenItem>();
        items.add(new HomeScreenItem(HomeScreenItemType.SCHEDULE, "Dagprogramma"));
        items.add(new HomeScreenItem(HomeScreenItemType.NAVIGATION, "Navigatie"));
        items.add(new HomeScreenItem(HomeScreenItemType.STUDY_INFO, "Studie informatie"));
        items.add(new HomeScreenItem(HomeScreenItemType.QUIZ, "Studiewijzer"));
        items.add(new HomeScreenItem(HomeScreenItemType.FLOORPLAN, "Plattegrond"));
        items.add(new HomeScreenItem(HomeScreenItemType.CONTACT, "Contact"));

        this._listView.setAdapter(new HomeScreenAdapter(getApplicationContext(), items));
        this._listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), ScheduleActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), NavigationActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), StudiesActivity.class);
                        startActivity(intent);
                        break;
//                    case 3:
//                        intent = new Intent(getApplicationContext(), SurveyActivity.class);
//                        startActivity(intent);
//                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), FloorplanActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Deze feature is nog in ontwikkeling", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
