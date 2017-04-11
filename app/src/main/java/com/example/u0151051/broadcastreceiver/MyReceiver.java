package com.example.u0151051.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by u0151051 on 2017/4/11.
 */
//廣播接收元件是一個繼承自「android.content.BroadcastReceiver」的子類別
// 它的任務是在接收到廣播事件後執行一些工作
// 這個元件只需要實作「onReceive」方法
// 在方法中實作接收到指定廣播事件以後需要執行的工作
public class MyReceiver extends BroadcastReceiver {
    @Override
    //第一個參數Context物件，用來顯示訊息框、啟動服務
    // 第二個參數是發出廣播事件的Intent物件，可以包含資料
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
