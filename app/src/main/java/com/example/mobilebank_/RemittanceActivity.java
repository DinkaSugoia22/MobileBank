package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RemittanceActivity extends AppCompatActivity {
    public double money;

    public int limit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remittance);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            money = extras.getDouble("money");
            limit = extras.getInt("limit");
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

    public void Rem2(View view){
        Intent remmitance2 = new Intent(this, RemittanceActivity2.class);
        remmitance2.putExtra("money", money);
        remmitance2.putExtra("limit", limit);
        startActivity(remmitance2);
    }
}