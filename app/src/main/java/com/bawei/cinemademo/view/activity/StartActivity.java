package com.bawei.cinemademo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.cinemademo.R;
import com.bawei.cinemademo.base.BaseActivity;

public class StartActivity extends BaseActivity {


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = null;
            switch (msg.what){
                case 0:
                    intent = new Intent(getBaseContext(),LoginActivity.class);
                    break;
                case 1:
                    intent = new Intent(getBaseContext(),MainActivity.class);
                    break;
            }
            startActivity(intent);
            finish();
        }
    };
    private SharedPreferences sp;
    private boolean frist;

    @Override
    protected int getLayoutId() {
        return (R.layout.activity_start);
    }

    @Override
    protected void initView() {
        sp = getSharedPreferences("mySP", Context.MODE_PRIVATE);
        frist = sp.getBoolean("frist", false);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                if (frist==true){
                    message.what = 0;
                }else {
                    message.what = 1;
                }
                handler.sendMessage(message);
            }
        },2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
