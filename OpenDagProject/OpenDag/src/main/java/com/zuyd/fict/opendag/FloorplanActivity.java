package com.zuyd.fict.opendag;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

import com.zuyd.fict.opendag.util.PanZoomImageView;

public class FloorplanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_floorplan);

        PanZoomImageView img = new PanZoomImageView(this);
        img.setImageResource(R.drawable.plattegrond);
        img.setMaxZoom(4f);

        //img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setContentView(img);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.floorplan, menu);
        return true;
    }
    
}
