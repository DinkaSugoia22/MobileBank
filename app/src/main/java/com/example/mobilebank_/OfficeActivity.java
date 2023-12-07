package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OfficeActivity extends AppCompatActivity {
    // TODO - добавить карту, адрес, все что угодно, что душа пожелает, просто чтобы смотрелось норм
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);
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


}