package com.example.iman.broadcastreseiver;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivitty extends AppCompatActivity implements View.OnClickListener {
    ListView listview_drawer;
    DrawerLayout drawer;
    ImageButton btn_burger_icon;
    Button btn_battery;
    Button btn_videoplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_activitty);
        bind();
        //button font
        Typeface font = Typeface.createFromAsset(getAssets(), "fontt.ttf");
        btn_battery.setTypeface(font);
        btn_videoplayer.setTypeface(font);
        //font
        String data[] = {"Sign In/Sign Up", "About We", "Support"};
        ListDrawer_Adapter adapter = new ListDrawer_Adapter(DrawerActivitty.this, data);
        listview_drawer.setAdapter(adapter);
    }


    private void bind() {
        btn_battery = findViewById(R.id.btn_battery);
        btn_videoplayer = findViewById(R.id.btn_videoplayer);
        listview_drawer = findViewById(R.id.listview_drawer);
        btn_burger_icon = findViewById(R.id.btn_burger_icon);
        drawer = findViewById(R.id.drawer);


        btn_videoplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videointent = new Intent(DrawerActivitty.this, VideoActivity.class);
                startActivity(videointent);
            }
        });
        btn_burger_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.openDrawer(Gravity.RIGHT);
                } else
                    drawer.openDrawer(Gravity.RIGHT);
            }
        });
        btn_battery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_battery) {
            Intent batteryintent = new Intent(this, BatteryActivity.class);
            startActivity(batteryintent);
        }
    }
}


