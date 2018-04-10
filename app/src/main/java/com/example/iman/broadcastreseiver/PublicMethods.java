package com.example.iman.broadcastreseiver;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Iman on 4/10/2018.
 */

public class PublicMethods {

   public static void showToast(Context mcontext,String msg){
       Toast.makeText(mcontext,msg,Toast.LENGTH_LONG).show();

   }
}
