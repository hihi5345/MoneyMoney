package com.example.kimhun.moneymoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;

/**
 * Created by kimhun on 2017-06-03.
 */

public class Account extends Activity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup group;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        final DBHelper dbHelper = new DBHelper(this);
        final DBLogin dbLogin = new DBLogin(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_day);
        TextView money_next = (TextView) findViewById(R.id.money_next);
        TextView text_History = (TextView) findViewById(R.id.money_History);
        text_History.setText(dbHelper.getHistory_day());
        money_next.setText(Integer.toString(dbLogin.getMoney()));
        group = (RadioGroup)findViewById(R.id.select);
        group.setOnCheckedChangeListener(this);
    }
    public void OnClick(View view) {
        Intent intent = new Intent(this, Go.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        final DBHelper dbHelper = new DBHelper(this);
        if(radioGroup == group){
            if(i == R.id.day){
                TextView text_History = (TextView) findViewById(R.id.money_History);
                text_History.setText(dbHelper.getHistory_day());
            } else if(i == R.id.week) {
                TextView text_History = (TextView) findViewById(R.id.money_History);
                try {
                    text_History.setText(dbHelper.getHistory_week());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else if(i == R.id.month){
                TextView text_History = (TextView) findViewById(R.id.money_History);
                try {
                    text_History.setText(dbHelper.getHistory_month());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
