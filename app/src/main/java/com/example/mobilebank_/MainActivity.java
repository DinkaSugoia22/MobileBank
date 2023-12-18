package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double money = 0;
    public int limit = 100000;
    private TextView moneyLabel;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money = 200000;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        money = sharedPreferences.getFloat("money", (float) money);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            limit = extras.getInt("limit", 0);
            money = extras.getDouble("money", money);
        }

        String moneyText = String.format("%.2f", money);

        moneyLabel = findViewById(R.id.money);
        moneyLabel.setText((moneyText));


    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("money", (float) money);
        editor.apply();
    }

    // TODO - Провести рефакторинг
    //  (тоже для всех activity, чтобы выглядело примерно одинаково и красиво)

    // TODO - Сделать оптимизацию кода(в будущем)

    // TODO - Реализовать модель MVVM(Model-View-ViewModel) в данном приложении,
    //  а также добавить методы onPause(), onResume() и т.д


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
        pay.putExtra("money", money);
        pay.putExtra("limit", limit);
        startActivity(pay);
    }

    public void officeClick(View view){
        Intent office = new Intent(this, OfficeActivity.class);
        startActivity(office);
    }
}