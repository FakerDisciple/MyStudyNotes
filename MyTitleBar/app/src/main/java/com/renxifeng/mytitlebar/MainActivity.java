package com.renxifeng.mytitlebar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.renxifeng.mytitlebar.view.MyTopTitleBar;

public class MainActivity extends AppCompatActivity {

    private MyTopTitleBar myTopTitleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTopTitleBar = (MyTopTitleBar) findViewById(R.id.home_top_bar);


        myTopTitleBar.setOnMyTopTitleBarClickListener(new MyTopTitleBar.OnMyTopTitleBarClickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }

            @Override
            public void onRightClick() {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });
    }
}
