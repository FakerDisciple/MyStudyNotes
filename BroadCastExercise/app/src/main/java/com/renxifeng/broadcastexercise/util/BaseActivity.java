package com.renxifeng.broadcastexercise.util;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Rxf on 2016/4/12 0012.
 */
public class BaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
