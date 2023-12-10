package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double money = 63000.31;

    public int limit = 0;
    private TextView moneyLabel;

    // TODO - можно переделать немного дизайн, изменить отступы, расположение, величины измерения(для всех activity)
    // TODO - по аналогии с переводом сделать окно для оплаты, скорее всего будут те же самые проблемы
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            limit = extras.getInt("limit");
            money = extras.getDouble("money", money);
        }

        moneyLabel = findViewById(R.id.money);
        moneyLabel.setText(String.valueOf(money));

    }

    // TODO - Возможно провести рефакторинг(тоже для всех activity, чтобы выглядело примерно одинаково и красиво) :)
    public void exitClick(View view){
        this.finishAffinity();
    }

    public void profileClick(View view){
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }
    public void remittanceClick(View view){
        Intent remmitance = new Intent(this, RemittanceActivity.class);
        remmitance.putExtra("money", money);
        remmitance.putExtra("limit", limit);
        startActivity(remmitance);
    }
    public void payClick(View view){
        Intent pay = new Intent(this, PayActivity.class);
        startActivity(pay);
    }

    public void officeClick(View view){
        Intent office = new Intent(this, OfficeActivity.class);
        startActivity(office);
    }
}