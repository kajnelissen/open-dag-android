package com.zuyd.fict.opendag;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zuyd.fict.opendag.data.EntityManager;
import com.zuyd.fict.opendag.data.IEntityManager;
import com.zuyd.fict.opendag.model.Photo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;
import com.squareup.picasso.*;

public class NavigationActivity extends Activity {

    private List<Photo> _photos;
    private Map<Integer, Photo> _items;

    private final String LOG_TAG = "Navigation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        IEntityManager em = EntityManager.getInstance();
        this._items = em.photos().getAll();

        HorizontalScrollView scrollview = (HorizontalScrollView) findViewById(R.id.scrollview);

        LinearLayout ll = new LinearLayout(getApplicationContext());

        ArrayList sortedKeys=new ArrayList(_items.keySet());
        Collections.sort(sortedKeys);

        for(int i = 0; i < this._items.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            ll.addView(imageView);
        }

        int i = 0;
        for(Map.Entry<Integer, Photo> entry : _items.entrySet()){
// int key = sortedKeys.get(index).hashCode();
            int key = entry.getKey();

            Photo photo = this._items.get(key);

            LinearLayout l = new LinearLayout(getApplicationContext());

            ImageView imageView = new ImageView(getApplicationContext());
            String url = "http://opendagzuyd2013-001-site1.smarterasp.net/images/" + photo.getFileName();

            Picasso.with(this).load(url).into(imageView);

            for(int index = 0; index < sortedKeys.size(); index++){
                if(sortedKeys.get(index).hashCode() == key){
                    i = index;
                }
            }

            l.addView(imageView);

            ll.removeViewAt(i);
            ll.addView(l, i);
        }
        scrollview.addView(ll);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

}