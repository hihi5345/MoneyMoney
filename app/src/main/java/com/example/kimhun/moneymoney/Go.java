package com.example.kimhun.moneymoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Go extends Activity{
    TextView name_next;
    TextView money_next;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        Intent intent_name = getIntent();
        Intent intent_money = getIntent();
        String name = intent_name.getStringExtra("name");
        String money = intent_money.getStringExtra("money");

        name_next = (TextView)findViewById(R.id.name_next);
        money_next = (TextView)findViewById(R.id.money_next);
        name_next.setText(name);
        money_next.setText(money);
    }
}