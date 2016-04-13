package com.renxifeng.filestoragestudy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private SharedPreferences preferences; //共享参数

    private SharedPreferences.Editor editor; //共享参数的编辑者

    private EditText Account;

    private EditText password;

    private CheckBox rememberPassword;

    private Button  loginButton;
    private void init() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this); //初始化共享参数

        Account = (EditText) findViewById(R.id.login_account);
        password = (EditText) findViewById(R.id.login_password);
        rememberPassword = (CheckBox) findViewById(R.id.remember_password);
        loginButton = (Button) findViewById(R.id.login_in_button);

        boolean isRemember = preferences.getBoolean("remember_password", false); //是否记住密码
        if (isRemember){
            String userAccount = preferences.getString("user_account", "");
            String userPassword = preferences.getString("user_password","");
            Account.setText(userAccount);
            password.setText(userPassword);
            rememberPassword.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAccount  = Account.getText().toString();
                String userPassword = password.getText().toString();
                if (userAccount.equals("admin") && userPassword.equals("123456")){
                    editor = preferences.edit();
                    if (rememberPassword.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("user_account", userAccount);
                        editor.putString("user_password",userPassword);
                    }else {
                        editor.clear();
                    }
                    editor.commit();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Error! your Account or password mistake", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
