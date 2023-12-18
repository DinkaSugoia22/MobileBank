package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PayActivity2 extends AppCompatActivity {
    public double money;
    public int limit;
    // TODO Добавить сканнер QR-code
    // TODO Добавить три (или больше) различных окна для каждой из кнопок на прошлом окне. Т.е отдельно для оплаты счетов, налогов и др.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);
        EditText account = findViewById(R.id.account);
        account.setHintTextColor(Color.rgb(173, 111, 176));
        EditText sum = findViewById(R.id.sum);
        sum.setHintTextColor(Color.rgb(173, 111, 176));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            money = extras.getDouble("money");
            limit = extras.getInt("limit");
        }
    }
    public void exitClick(View view) {
        this.finishAffinity();
    }

    public void profileClick(View view) {
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }

    public void menuClick(View view) {
        Intent menu = new Intent(this, MainActivity.class);
        menu.putExtra("money", money);
        startActivity(menu);
    }

    public void toPay(View view) {
        EditText account = findViewById(R.id.account);
        EditText sum = findViewById(R.id.sum);
        String acc = account.getText().toString();
        String sumText = sum.getText().toString();

        if(sumText.isEmpty() || acc.isEmpty()) {
            Toast toast = Toast.makeText(this, "Некоторые поля не заполнены", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        double sumD = Double.parseDouble(sumText);

        if (acc != null) {
            if (acc.length() == 20 && sumD > 0) {
                if (sumD <= money) {
                    if (sumD <= limit) {
                        money -= sumD;
                        Toast toast = Toast.makeText(this, "Перевод успешно выполнен" , Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else {
                        Toast toast = Toast.makeText(this, "Сумма превышает лимит", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else{
                    Toast toast = Toast.makeText(this, "Сумма превышает баланс", Toast.LENGTH_LONG);
                    toast.show();
                }
            } else {
                Toast toast = Toast.makeText(this, "Некоторые поля указаны неверно", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
