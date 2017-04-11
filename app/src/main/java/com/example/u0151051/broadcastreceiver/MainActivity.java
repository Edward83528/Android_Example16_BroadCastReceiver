package com.example.u0151051.broadcastreceiver;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//寫一個繼承自 BroadCastReceiver 的 Class, 處理 onReceive() 事件(並在AndroidManifest裡註冊這個 BroadCastReceiver Class)
public class MainActivity extends AppCompatActivity {
    public static final String ACTION_SHOW_DIALOG = "com.example.u0151051.broadcastreceiver.showdialog";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }

    void findview() {
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(c);
    }

    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //發送廣播(App內廣播的發送是透過intent以及 sendBroadCast(intent) 來發送的)
            Intent intent = new Intent();
            intent.setAction(ACTION_SHOW_DIALOG);
            sendBroadcast(intent);
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        //廣播會傳
        Intent intent = getIntent();
        if (intent.getAction().equals(ACTION_SHOW_DIALOG)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("提醒您");
            builder.setMessage("收到訊息");
            builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "您確實收到訊息", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
    }
}
