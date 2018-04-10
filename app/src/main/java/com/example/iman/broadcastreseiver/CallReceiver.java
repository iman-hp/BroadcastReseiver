package com.example.iman.broadcastreseiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by Iman on 4/10/2018.
 */

public class CallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        PublicMethods.showToast(context ,"call omad");
    }
}
