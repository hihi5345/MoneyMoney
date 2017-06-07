package com.example.kimhun.moneymoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by kimhun on 2017-06-03.
 */

public class Check extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

    }
    public void OnClick(View view) {
        Intent intent = new Intent(this, Go.class);
        startActivity(intent);
        finish();
    }
}
