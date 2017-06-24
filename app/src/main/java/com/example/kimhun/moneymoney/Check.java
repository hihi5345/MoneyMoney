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

public class Check extends Activity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup group;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        final DBHelper dbHelper = new DBHelper(this);
        final DBLogin dbLogin = new DBLogin(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        TextView money_next = (TextView) findViewById(R.id.money_next);
        money_next.setText(Integer.toString(dbLogin.getMoney()));
        try {
            TextView text_income_now = (TextView) findViewById(R.id.income_Now);
            TextView text_income_before = (TextView) findViewById(R.id.income_Before);
            TextView text_outgoing_now = (TextView) findViewById(R.id.outgoing_Now);
            TextView text_outgoing_before = (TextView) findViewById(R.id.outgoing_Before);
            TextView text_outgoing_min_now = (TextView) findViewById(R.id.income_minus_outgoing_now);
            TextView text_outgoing_min_before = (TextView) findViewById(R.id.income_minus_outgoing_before);
            text_income_now.setText(dbHelper.get_income_now(1));
            text_income_before.setText(dbHelper.get_income_before(1));
            text_outgoing_now.setText(dbHelper.get_now(1));
            text_outgoing_before.setText(dbHelper.get_before(1));
            text_outgoing_min_now.setText(dbHelper.get_min_now(1));
            text_outgoing_min_before.setText(dbHelper.get_min_before(1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
                try {
                    TextView text_income_now = (TextView) findViewById(R.id.income_Now);
                    TextView text_income_before = (TextView) findViewById(R.id.income_Before);
                    TextView text_outgoing_now = (TextView) findViewById(R.id.outgoing_Now);
                    TextView text_outgoing_before = (TextView) findViewById(R.id.outgoing_Before);
                    TextView text_outgoing_min_now = (TextView) findViewById(R.id.income_minus_outgoing_now);
                    TextView text_outgoing_min_before = (TextView) findViewById(R.id.income_minus_outgoing_before);
                    text_income_now.setText(dbHelper.get_income_now(1));
                    text_income_before.setText(dbHelper.get_income_before(1));
                    text_outgoing_now.setText(dbHelper.get_now(1));
                    text_outgoing_before.setText(dbHelper.get_before(1));
                    text_outgoing_min_now.setText(dbHelper.get_min_now(1));
                    text_outgoing_min_before.setText(dbHelper.get_min_before(1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            } else if(i == R.id.week) {
                try {
                    TextView text_income_now = (TextView) findViewById(R.id.income_Now);
                    TextView text_income_before = (TextView) findViewById(R.id.income_Before);
                    TextView text_outgoing_now = (TextView) findViewById(R.id.outgoing_Now);
                    TextView text_outgoing_before = (TextView) findViewById(R.id.outgoing_Before);
                    TextView text_outgoing_min_now = (TextView) findViewById(R.id.income_minus_outgoing_now);
                    TextView text_outgoing_min_before = (TextView) findViewById(R.id.income_minus_outgoing_before);
                    text_income_now.setText(dbHelper.get_income_now(2));
                    text_income_before.setText(dbHelper.get_income_before(2));
                    text_outgoing_now.setText(dbHelper.get_now(2));
                    text_outgoing_before.setText(dbHelper.get_before(2));
                    text_outgoing_min_now.setText(dbHelper.get_min_now(2));
                    text_outgoing_min_before.setText(dbHelper.get_min_before(2));
                } catch (ParseException e){
                    e.printStackTrace();
                }
            } else if(i == R.id.month){
                try {
                    TextView text_income_now = (TextView) findViewById(R.id.income_Now);
                    TextView text_income_before = (TextView) findViewById(R.id.income_Before);
                    TextView text_outgoing_now = (TextView) findViewById(R.id.outgoing_Now);
                    TextView text_outgoing_before = (TextView) findViewById(R.id.outgoing_Before);
                    TextView text_outgoing_min_now = (TextView) findViewById(R.id.income_minus_outgoing_now);
                    TextView text_outgoing_min_before = (TextView) findViewById(R.id.income_minus_outgoing_before);
                    text_income_now.setText(dbHelper.get_income_now(3));
                    text_income_before.setText(dbHelper.get_income_before(3));
                    text_outgoing_now.setText(dbHelper.get_now(3));
                    text_outgoing_before.setText(dbHelper.get_before(3));
                    text_outgoing_min_now.setText(dbHelper.get_min_now(3));
                    text_outgoing_min_before.setText(dbHelper.get_min_before(3));
                } catch(ParseException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
