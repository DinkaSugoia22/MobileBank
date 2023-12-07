package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RemittanceActivity2 extends AppCompatActivity {

    // TODO Добавить сканнер QR-code
    // TODO Возможно добавить три различных окна для каждой из кнопок на прошлом окне. Т.е отдельно по Сбп, клиенту банка, в другую страну (по желанию)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remittance2);
        EditText phone = findViewById(R.id.phoneNum);
        phone.setHintTextColor(Color.rgb(173, 111, 176));
        EditText sum = findViewById(R.id.sum);
        sum.setHintTextColor(Color.rgb(173, 111, 176));

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
        startActivity(menu);
    }

    public void toRemit(View view) {
        EditText phone = findViewById(R.id.phoneNum);
        EditText sum = findViewById(R.id.sum);
        String mob = phone.getText().toString();
        String sumText = sum.getText().toString();
        double sumD = Double.parseDouble(sumText);
        // TODO - приложение крашит при пустом поле суммы, а также при попытке получить данные с другого активити по ключу (исправить)
        if (mob != null) {
            if (!sumText.equals("")) {
                if (((mob.length() == 12 && mob.contains("+7"))
                        || (mob.length() == 11 && mob.substring(0, 1).contains("8")))) {
                    Toast toast = Toast.makeText(this, "Перевод успешно выполнен", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(this, "Некоторые поля не заполнены или указаны неверно", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }
    }
}
