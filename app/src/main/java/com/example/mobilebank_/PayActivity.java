package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PayActivity extends AppCompatActivity {
    //TODO - в этом активити и двух последующих можно поменять вид кнопок, если что-то придумаем. Или оставить так
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
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