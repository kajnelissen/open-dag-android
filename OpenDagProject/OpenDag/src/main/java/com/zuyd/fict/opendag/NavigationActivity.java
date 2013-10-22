package com.zuyd.fict.opendag;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.HorizontalScrollView;

import com.zuyd.fict.opendag.model.Photo;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends Activity {

    private List<Photo> _photos;

    private final String LOG_TAG = "Navigation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        this._photos = new ArrayList<Photo>();

        setContentView(R.layout.activity_navigation);
        HorizontalScrollView scrollview = (HorizontalScrollView) findViewById(R.id.scrollview);
//LinearLayout hll = (LinearLayout) findViewById(R.id.horizontalLL);
        LinearLayout ll = new LinearLayout(getApplicationContext());

        for(int i = 0; i < this._photos.size(); i++){
            Photo photo = this._photos.get(i);
            String baseString = photo.getImage();
            byte[] decodedString = Base64.decode(baseString, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

            LinearLayout l = new LinearLayout(getApplicationContext());
            ImageView iv = new ImageView(getApplicationContext());

            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;

            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,width);
            iv.setLayoutParams(parms);

            iv.setImageBitmap(decodedByte);
            l.addView(iv);

            ll.addView(l);

//hll.addView(iv);
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
