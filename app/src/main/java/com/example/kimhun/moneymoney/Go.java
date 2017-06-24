package com.example.kimhun.moneymoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Go extends Activity implements RadioGroup.OnCheckedChangeListener{
    EditText editIncome;
    EditText editOutgoing;
    RadioGroup group;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        group = (RadioGroup)findViewById(R.id.select);
        group.setOnCheckedChangeListener(this);
        final DBLogin dbLogin = new DBLogin(this);
        TextView name_next = (TextView) findViewById(R.id.name_next);
        TextView money_next = (TextView) findViewById(R.id.money_next);
        name_next.setText(dbLogin.getName());
        money_next.setText(Integer.toString(dbLogin.getMoney()));
    }
    public void OnClick(View view) {
        Calendar cal = Calendar.getInstance();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
        formatter.setTimeZone(cal.getTimeZone());
        String formatted = formatter.format(cal.getTime());
        final DBLogin dbLogin = new DBLogin(this);
        final DBHelper dbHelper = new DBHelper(this);
        int in, out;
        editIncome = (EditText) findViewById(R.id.edit_income);
        editOutgoing = (EditText) findViewById(R.id.edit_outgoing);
        String in_string = editIncome.getText().toString();
        String out_string = editOutgoing.getText().toString();
        if (in_string.equals("")) in = 0;
        else in = Integer.parseInt(in_string);
        if (out_string.equals("")) out = 0;
        else out = Integer.parseInt(out_string);
        if (in != 0) {
            dbLogin.update(dbLogin.getName(), dbLogin.getMoney() + in - out);
            try {
                dbHelper.insert(formatted, "수입", in);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, Go.class);
            startActivity(intent);
            finish();
        }
    }

    public void OnAccount(View view){
        Intent intent = new Intent(this,Account.class);
        startActivity(intent);
        finish();
    }
    public void OnOutgoing(View view){
        Intent intent = new Intent(this,Check.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if(radioGroup == group){
            if(i == R.id.income){
                Intent intent = new Intent(this,Go.class);
                startActivity(intent);
                finish();
            } else if(i == R.id.outgoing) {
                Intent intent = new Intent(this,Go2.class);
                startActivity(intent);
                finish();
            }

        }
    }
}