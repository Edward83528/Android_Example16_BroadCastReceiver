package com.example.u0151051.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by u0151051 on 2017/4/11.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //接收廣播
        if (intent.getAction().equals(MainActivity.ACTION_SHOW_DIALOG)) {
            Intent newintent = new Intent();
            newintent.setClassName("com.example.u0151051.broadcastreceiver", "com.example.u0151051.broadcastreceiver.MainActivity");
            newintent.setAction(MainActivity.ACTION_SHOW_DIALOG);
            newintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(newintent);
        }
    }
}
