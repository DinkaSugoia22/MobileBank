package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PayActivity extends AppCompatActivity {
    public double money;

    public int limit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            money = extras.getDouble("money");
            limit = extras.getInt("limit", 0);
        }
    }
    public void menuClick(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
    public void exitClick(View view){
        this.finishAffinity();
    }

    public void profileClick(View view){
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
    public void pay(View view){
        Intent pay2 = new Intent(this, PayActivity2.class);
        pay2.putExtra("money", money);
        pay2.putExtra("limit", limit);
        startActivity(pay2);
    }
}