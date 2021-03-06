package com.example.kimhun.moneymoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClick(View view){
        final DBLogin dbLogin = new DBLogin(this);
        EditText editName = (EditText)findViewById(R.id.edit_name);
        EditText editMoney = (EditText)findViewById(R.id.edit_money);
        String message = editName.getText().toString();
        String money = editMoney.getText().toString();
        dbLogin.insert(message,Integer.parseInt(money));
        Intent intent = new Intent(this,Go.class);
        startActivity(intent);
        finish();
    }
}
