package com.example.iman.broadcastreseiver;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_screenAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_acivity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainintent=new Intent(Splash_screenAcivity.this,DrawerActivitty.class);
                startActivity(mainintent);
            }
        },3000);
    }
}
