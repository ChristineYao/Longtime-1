package com.example.birdbaby.longtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

/**
 * Created by birdbaby on 2016/6/27.
 */
public class RegisterActivity extends Activity {
    //声明组件
    private Button register_bt, cancel;
    private RadioButton male, female;
    private EditText username, password;
    private CheckBox reading, sports, party, eat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //根据ID获取组件对象
        register_bt = (Button) findViewById(R.id.register_button);
        cancel = (Button) findViewById(R.id.cancel);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        reading = (CheckBox) findViewById(R.id.reading);
        sports = (CheckBox) findViewById(R.id.sports);
        party = (CheckBox) findViewById(R.id.party);
        eat = (CheckBox) findViewById(R.id.eat);
    }

    public void onClickRes(View v) {
        Log.i("tag", "username:" + username.getText().toString());
        Log.i("tag", "password:" + password.getText().toString());
        Log.i("tag", "repassword:" + password.getText().toString());
        if (male.isChecked()) {
            Log.i("tag", "sex:male");
        } else {
            Log.i("tag", "sex:female");
        }
        String temp = "like:";
        if (reading.isChecked()) {
            temp += "read";
        }
        if (sports.isChecked()) {
            temp += "sports";
        }
        if (party.isChecked()) {
            temp += "party";
        }
        if (eat.isChecked()) {
            temp += "eat";
        }
    }

    public void onClickCancel(View v){
        // Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
        //利用startAcitivity启动新的Activity
        startActivity(intent);
        //关闭当前Activity
        RegisterActivity.this.finish();
    }


}