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

public class RemittanceActivity2 extends AppCompatActivity {
    public double money;
    public int limit;
    // TODO Добавить сканнер QR-code
    // TODO Добавить три (или больше) различных окна для каждой из кнопок на прошлом окне. Т.е отдельно по Сбп, клиенту банка, в другую страну и др.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remittance2);
        EditText phone = findViewById(R.id.phoneNum);
        phone.setHintTextColor(Color.rgb(173, 111, 176));
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

    public void toRemit(View view) {
        EditText phone = findViewById(R.id.phoneNum);
        EditText sum = findViewById(R.id.sum);
        String mob = phone.getText().toString();
        String sumText = sum.getText().toString();

        if(sumText.isEmpty() || mob.isEmpty()) {
            Toast toast = Toast.makeText(this, "Некоторые поля не заполнены", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        double sumD = Double.parseDouble(sumText);

        if (mob != null) {
                if (((mob.length() == 12 && mob.contains("+7"))
                        || (mob.length() == 11 && mob.substring(0, 1).contains("8")))
                            && sumD > 0) {
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
