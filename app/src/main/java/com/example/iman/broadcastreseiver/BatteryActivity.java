package com.example.iman.broadcastreseiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {
    ImageView img_battery;
    TextView txt_charge_num;
    TextView txt_state;
    BroadcastReceiver batterystate;
    ImageView img_power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);
        bindviews();


        batterystate = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                boolean usbcharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
                if (usbcharge == true)
                    txt_state.setText("connect");


                else if (usbcharge == false)
                    txt_state.setText("disconnect");






                if (level == 100 )
                    img_battery.setImageResource(R.drawable.batteryfull);
                else if (level == 50)
                    img_battery.setImageResource(R.drawable.batteryhalf);
                else if (level > 50|| usbcharge==true)
                    img_battery.setImageResource(R.drawable.batterygood);
                else
                    img_battery.setImageResource(R.drawable.batterylow);
                txt_charge_num.setText(String.valueOf(level) + "%");
            }
        };
        this.registerReceiver(this.batterystate, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }


    void bindviews() {
        img_battery = findViewById(R.id.img_battery);
        txt_charge_num = findViewById(R.id.txt_charge_num);
        txt_state = findViewById(R.id.txt_state);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(batterystate);
        super.onDestroy();
    }
}
