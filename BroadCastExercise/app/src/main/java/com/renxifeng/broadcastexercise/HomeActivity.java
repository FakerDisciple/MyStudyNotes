package com.renxifeng.broadcastexercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.renxifeng.broadcastexercise.util.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private Button forceOfflineButton;
    private void initView() {
        forceOfflineButton = (Button) findViewById(R.id.force_offline);
        forceOfflineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.renxifeng.broadcastexercise.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
