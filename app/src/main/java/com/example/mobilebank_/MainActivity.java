package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double money = 5000.00;
    private TextView moneyLabel;
    // TODO - можно переделать немного дизайн, изменить отступы, расположение, величины измерения(для всех activity)
    // TODO - попробовать передать money на другое activity
    // TODO - по аналогии с переводом сделать окно для оплаты, скорее всего будут те же самые проблемы
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyLabel = findViewById(R.id.money);
        moneyLabel.setText(String.valueOf(money));

        Intent rem2 = new Intent(this, RemittanceActivity2.class);
        rem2.putExtra("money", money);

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
        Intent remittance = new Intent(this, RemittanceActivity.class);
        startActivity(remittance);
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