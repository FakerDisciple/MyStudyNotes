package com.renxifeng.broadcastexercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.renxifeng.broadcastexercise.util.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private void initView() {
        accountEdit = (EditText) findViewById(R.id.user_account);
        passwordEdit = (EditText) findViewById(R.id.user_password);
        loginButton = (Button) findViewById(R.id.user_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountStr = accountEdit.getText().toString();
                String passwordStr = passwordEdit.getText().toString();
                if (passwordStr != null && accountStr != null) {
                    if (accountStr.equals("admin") && passwordStr.equals("123456")){
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(MainActivity.this,"error",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
